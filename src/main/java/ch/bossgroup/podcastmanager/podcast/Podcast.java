package ch.bossgroup.podcastmanager.podcast;

import ch.bossgroup.podcastmanager.artist.Artist;
import ch.bossgroup.podcastmanager.topic.Topic;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Podcast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 2, max = 30)
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9$&\\-_,.!?]+$")
    private String title;

    @Column()
    @Size(max = 250)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "podcast_artist",
            joinColumns = @JoinColumn(name = "podcast_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<Artist> artists;

    @ManyToMany
    @JoinTable(
            name = "podcast_topic",
            joinColumns = @JoinColumn(name = "podcast_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id")
    )

    private List<Topic> topics;
}
