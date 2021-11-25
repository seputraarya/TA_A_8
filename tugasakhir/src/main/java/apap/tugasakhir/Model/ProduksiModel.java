package apap.tugasakhir.Model;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "produksi")
public class ProduksiModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduksi;

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
    @Column(name = "tanggal_produksi", nullable = false)
    private Date tanggalProduksi;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private MesinModel mesin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_request_update_item", referencedColumnName = "idRequestUpdateItem")
    @JsonIgnore
    private RequestUpdateItemModel requestUpdateItem;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PegawaiModel pegawai;
}
