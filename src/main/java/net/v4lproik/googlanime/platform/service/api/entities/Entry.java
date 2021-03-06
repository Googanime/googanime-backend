package net.v4lproik.googlanime.platform.service.api.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@DiscriminatorColumn(name="type_jpa")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name = "Anime")
public class Entry {

    @Id
    @Column(name = "id")
    private Long id;

    private String type;

    private String title;

    private String englishTitle;

    private String japaneseTitle;

    private String synopsis;

    private String startedAiringDate;

    private String rank;

    private String popularity;

    private String score;

    private String finishedAiringDate;

    private String ageRating;

    private String posterImage;


    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "entry")
    @ElementCollection
    private Set<Synonym> synonyms;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="Anime_has_Genre",
            joinColumns={@JoinColumn(name="idAnime", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="idGenre", referencedColumnName="id")
            })
    @ElementCollection
    private Set<Genre> genres;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="Anime_has_Author",
            joinColumns={@JoinColumn(name="idAnime", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="idAuthor", referencedColumnName="id")
            })
    @ElementCollection
    private Set<Author> authors;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="Anime_has_Tag",
            joinColumns={@JoinColumn(name="idAnime", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="idTag", referencedColumnName="id")
            })
    @ElementCollection
    private Set<Tag> tags;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="Anime_has_Character",
            joinColumns={@JoinColumn(name="idAnime", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="idCharacter", referencedColumnName="id")
            })
    @ElementCollection
    private Set<Character> characters;

    //Recursive dependecnies

    @Transient
    private List<AnimeId> sequels;

    @Transient
    private List<AnimeId> alternativeVersions;

    @Transient
    private List<AnimeId> prequels;

    @Transient
    private List<AnimeId> spinoff;

    @Transient
    private List<AnimeId> sideStories;

    @Transient
    private List<AnimeId> others;

    @Transient
    private List<AnimeId> summaries;

    @Transient
    private List<AnimeId> adaptations;

    @Transient
    private List<AnimeId> parentStories;


    public Entry(Long id) {
        this.id = id;
    }

    public Entry() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnglishTitle() {
        return englishTitle;
    }

    public void setEnglishTitle(String englishTitle) {
        this.englishTitle = englishTitle;
    }

    public String getJapaneseTitle() {
        return japaneseTitle;
    }

    public void setJapaneseTitle(String japaneseTitle) {
        this.japaneseTitle = japaneseTitle;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getStartedAiringDate() {
        return startedAiringDate;
    }

    public void setStartedAiringDate(String startedAiringDate) {
        this.startedAiringDate = startedAiringDate;
    }

    public String getFinishedAiringDate() {
        return finishedAiringDate;
    }

    public void setFinishedAiringDate(String finishedAiringDate) {
        this.finishedAiringDate = finishedAiringDate;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public String getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(String posterImage) {
        this.posterImage = posterImage;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AnimeId> getSequels() {
        return sequels;
    }

    public void setSequels(List<AnimeId> sequels) {
        this.sequels = sequels;
    }

    public List<AnimeId> getAlternativeVersions() {
        return alternativeVersions;
    }

    public void setAlternativeVersions(List<AnimeId> alternativeVersions) {
        this.alternativeVersions = alternativeVersions;
    }

    public List<AnimeId> getPrequels() {
        return prequels;
    }

    public void setPrequels(List<AnimeId> prequels) {
        this.prequels = prequels;
    }

    public List<AnimeId> getSpinoff() {
        return spinoff;
    }

    public void setSpinoff(List<AnimeId> spinoff) {
        this.spinoff = spinoff;
    }

    public List<AnimeId> getSideStories() {
        return sideStories;
    }

    public void setSideStories(List<AnimeId> sideStories) {
        this.sideStories = sideStories;
    }

    public List<AnimeId> getOthers() {
        return others;
    }

    public void setOthers(List<AnimeId> others) {
        this.others = others;
    }

    public List<AnimeId> getSummaries() {
        return summaries;
    }

    public void setSummaries(List<AnimeId> summaries) {
        this.summaries = summaries;
    }

    public List<AnimeId> getAdaptations() {
        return adaptations;
    }

    public void setAdaptations(List<AnimeId> adaptations) {
        this.adaptations = adaptations;
    }

    public Set<Synonym> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(Set<Synonym> synonyms) {
        this.synonyms = synonyms;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;
        Entry entry = (Entry) o;
        return Objects.equals(getType(), entry.getType()) &&
                Objects.equals(getTitle(), entry.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getTitle());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", id)
                .append("type", type)
                .append("title", title)
                .append("synonyms", synonyms)
                .append("englishTitle", englishTitle)
                .append("japaneseTitle", japaneseTitle)
                .append("synopsis", synopsis)
                .append("startedAiringDate", startedAiringDate)
                .append("rank", rank)
                .append("popularity", popularity)
                .append("score", score)
                .append("finishedAiringDate", finishedAiringDate)
                .append("ageRating", ageRating)
                .append("posterImage", posterImage)
                .append("genres", genres)
                .append("authors", authors)
                .append("tags", tags)
                .append("sequels", sequels)
                .append("alternativeVersions", alternativeVersions)
                .append("prequels", prequels)
                .append("spinoff", spinoff)
                .append("sideStories", sideStories)
                .append("others", others)
                .append("summaries", summaries)
                .append("adaptations", adaptations)
                .append("characters", characters)
                .toString();
    }
}
