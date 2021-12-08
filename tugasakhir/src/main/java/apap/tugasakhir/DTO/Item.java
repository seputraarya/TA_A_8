package apap.tugasakhir.DTO;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Item {
    private String uuid;
    private String nama;
    private Integer harga;
    private Integer stok;
    private String kategori;
}
