package apap.tugasakhir.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProposeItem {
    private String nama;
    private Integer harga;
    private Integer stok;
    private String kategori;
}
