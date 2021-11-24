package apap.tugasakhir.Model;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "delivery")
public class DeliveryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDelivery;

    @NotNull
    @Column(name = "id_kurir", nullable = false)
    private int idKurir;

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

    @NotNull
    @Column(name = "id_request_update_item", nullable = false)
    private Long idRequestUpdateItem;
}
