package ch.bossgroup.podcastmanager.artist;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 2, max = 30)
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9$&\\-_,.!?]+$")
    private String firstname;

    @Column(nullable = false)
    @Size(min = 2, max = 30)
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9$&\\-_,.!?]+$")
    private String lastname;

    public Artist(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
