package apap.tugasakhir.Model;

import lombok.Setter;
import lombok.Getter;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Setter
@Getter
@Table(name = "mesin")
public class MesinModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMesin;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama_mesin", nullable = false)
    private String namaMesin;

    @NotNull
    @Column(name = "id_kategori", nullable = false)
    private Long idKategori;

    @NotNull
    @Column(name = "tanggal_dibuat", nullable = false)
    private Date tanggalDibuat;

    @NotNull
    @Column(name = "kapasitas", nullable = false)
    private Long kapasitas;

    @OneToMany(mappedBy = "mesin", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<ProduksiModel> produksiMesin;
}
