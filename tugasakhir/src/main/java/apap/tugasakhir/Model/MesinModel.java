package apap.tugasakhir.Model;

import lombok.Setter;

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
}
