package apap.tugasakhir.Model;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "request_update_item")
public class RequestUpdateItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRequestUpdateItem;

    @NotNull
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String idItem;

    @NotNull
    @Column(name = "id_kategori", nullable = false)
    private Long idKategori;

    @NotNull
    @Column(name = "tambahan_stok", nullable = false)
    private Long tambahanStok;

    @NotNull
    @Column(name = "tanggal_request", nullable = false)
    private Date tanggalRequest;

    @NotNull
    @Column(name = "id_cabang", nullable = false)
    private Long idCabang;

    @NotNull
    @Column(name = "executed", nullable = false)
    private int executed;

    @NotNull
    @Column(name = "id_delivery", nullable = false)
    private int idDelivery;

    @OneToOne
    @JsonIgnore
    private ProduksiModel produksi;
    // TODO: belum tau bener atau salah

    @OneToOne
    @JsonIgnore
    private DeliveryModel delivery;
    // TODO: belum tau bener atau salah
}