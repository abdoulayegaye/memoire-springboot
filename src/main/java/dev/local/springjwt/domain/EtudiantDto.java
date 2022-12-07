package dev.local.springjwt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantDto {
    private Long id;
    @NotNull
    private String matriculeET;
    @NotNull
    private String classe;
}
