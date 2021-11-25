package apap.tugasakhir.Model;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Setter
@Getter
@Table(name = "delivery")
public class DeliveryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDelivery;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name ="idKurir", referencedColumnName = "idPegawai", nullable = false)
    @JsonIgnore
    private PegawaiModel pegawai;

    @NotNull
    @Column(name = "id_cabang", nullable = false)
    private int idCabang;

    @NotNull
    @Column(name = "tanggal_dibuat", nullable = false)
    private Date tanggalDibuat;

    @NotNull
    @Column(name = "tanggal_dikirim", nullable = false)
    private Date tanggalDikirim;

    @NotNull
    @Column(name = "sent", nullable = false)
    private int sent;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_request_update_item" )
    @JsonIgnore
    private RequestUpdateItemModel requestUpdateItem;



}
