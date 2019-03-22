package mappingAnnotation;


import javax.persistence.*;

@Entity
@Table(name = "body")
public class BodyAnnatation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nameBody")
    private String nameBody;

    public BodyAnnatation() {
    }

    public BodyAnnatation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBody() {
        return nameBody;
    }

    public void setNameBody(String nameBody) {
        this.nameBody = nameBody;
    }
}
