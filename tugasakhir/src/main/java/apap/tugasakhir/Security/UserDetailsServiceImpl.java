package apap.tugasakhir.Security;

import java.util.HashSet;

import apap.tugasakhir.Model.PegawaiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;

import apap.tugasakhir.Repository.UserDb;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired(required = false)
    private UserDb userDb;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PegawaiModel user = userDb.findByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getNamaRole()));
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

}