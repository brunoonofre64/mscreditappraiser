package io.github.brunoonofre64.mscreditappraiser.domain.dto.evaluation;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataForEvaluationDTO {
    private String cpf;
    private Long income;
    private Long age;
}
