package ua.goit;

import javax.persistence.*;

@Entity
@Table(name = "CALCULATIONS")
public class Calculation {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "FORMULA", nullable = false)
    private String formula;

    @Column(name = "ANSWER", nullable = false)
    private String answer;

    public Calculation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
