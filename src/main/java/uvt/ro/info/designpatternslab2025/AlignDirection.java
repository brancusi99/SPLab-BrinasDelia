package uvt.ro.info.designpatternslab2025;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class AlignDirection implements AlignStrategy {

    @Id
    @GeneratedValue
    private Long id;

    @Override
    public void render(Paragraph paragraph) {

    }

}
