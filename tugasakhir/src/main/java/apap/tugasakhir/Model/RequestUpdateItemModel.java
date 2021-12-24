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
@Table(name = "requestupdateitem")
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

    @Column(name = "tanggal_request")
    private Date tanggalRequest;

    @NotNull
    @Column(name = "id_cabang", nullable = false)
    private Long idCabang;

    @Column(name = "executed")
    private Boolean executed;

    @OneToOne(mappedBy = "requestUpdateItem")
    @JsonIgnore
    private ProduksiModel produksi;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_delivery")
    @JsonIgnore
    private DeliveryModel delivery;
}
