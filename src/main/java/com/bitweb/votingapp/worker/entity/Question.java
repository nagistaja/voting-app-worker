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

@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "question")
@GenericGenerator(
        name = "assigned-sequence",
        strategy = "com.bitweb.votingapp.worker.util.AssignedSequenceStyleGenerator",
        parameters = {
                @org.hibernate.annotations.Parameter(
                        name = "sequence_name",
                        value = "questions_id_seq"),
                @org.hibernate.annotations.Parameter(
                        name = "optimizer",
                        value = "none")
        })
public class Question extends BaseEntity {
    private static final long serialVersionUID = 3549105726733403361L;

    private Survey survey;
    private List<Answer> answers;
    private List<Response> responses;
    private String text;
    private String description;

    public Question() {
        super();
    }

    /**
     * Get the survey question is for
     * @return survey
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")
    public Survey getSurvey() {
        return survey;
    }

    /**
     * Get answer options for question
     * @return answers
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    @OrderBy("id ASC")
    public List<Answer> getAnswers() {
        return answers;
    }

    /**
     * Get submitted responses for question
     * @return responses
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    @OrderBy("id ASC")
    public List<Response> getResponses() {
        return responses;
    }

    /**
     * Get question main text, shown at survey
     * @return question text
     */
    @NotNull(message = ValidationMessages.NOT_NULL)
    @Size(max = FieldsLength.QUESTION_TEXT, message = ValidationMessages.MAX_LENGTH_EXCEEDED)
    @Column(length = FieldsLength.QUESTION_TEXT, nullable = false)
    public String getText() {
        return text;
    }

    /**
     * Get question description, not visible to users
     * @return question description
     */
    @Size(max = FieldsLength.QUESTION_DESCRIPTION, message = ValidationMessages.MAX_LENGTH_EXCEEDED)
    @Column(length = FieldsLength.QUESTION_DESCRIPTION)
    public String getDescription() {
        return description;
    }
}
