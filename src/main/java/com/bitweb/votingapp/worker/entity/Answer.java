package com.bitweb.votingapp.worker.entity;

import com.bitweb.votingapp.worker.constant.FieldsLength;
import com.bitweb.votingapp.worker.constant.ValidationMessages;
import com.bitweb.votingapp.worker.entity.base.BaseEntity;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Possible answers for questions
 */
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "answer")
@GenericGenerator(
        name = "assigned-sequence",
        strategy = "com.bitweb.votingapp.worker.util.AssignedSequenceStyleGenerator",
        parameters = {
                @org.hibernate.annotations.Parameter(
                        name = "sequence_name",
                        value = "answers_id_seq"),
                @org.hibernate.annotations.Parameter(
                        name = "optimizer",
                        value = "none")
        })
public class Answer extends BaseEntity {
    private static final long serialVersionUID = 1549505726733603361L;

    private Question question;
    private List<Response> responses;
    private String text;
    private String description;
    private Boolean hidden;

    public Answer() {
        super();
    }

    /**
     * Get the question answer is for
     * @return question
     */
    @NotNull(message = ValidationMessages.NOT_NULL)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false, updatable = false)
    public Question getQuestion() {
        return question;
    }

    /**
     * Get submitted responses with answer
     * @return responses
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "answer")
    @OrderBy("id ASC")
    public List<Response> getResponses() {
        return responses;
    }

    /**
     * Get answer main text, shown at poll
     * @return answer text
     */
    @NotNull(message = ValidationMessages.NOT_NULL)
    @Size(max = FieldsLength.ANSWER_TEXT, message = ValidationMessages.MAX_LENGTH_EXCEEDED)
    @Column(length = FieldsLength.ANSWER_TEXT, nullable = false)
    public String getText() {
        return text;
    }

    /**
     * Get answer description, not visible to users
     * @return answer description
     */
    @Size(max = FieldsLength.ANSWER_DESCRIPTION, message = ValidationMessages.MAX_LENGTH_EXCEEDED)
    @Column(length = FieldsLength.ANSWER_DESCRIPTION)
    public String getDescription() {
        return description;
    }

    /**
     * If for some reason during survey is need to disable some answers
     * @return hidden
     */
    public Boolean getHidden() {
        return hidden;
    }
}
