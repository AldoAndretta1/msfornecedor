package br.com.rd.mscliente.infrastructure.persistence.product;

import br.com.rd.mscliente.domain.dto.ProductRequest;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produto")
@Getter
@Setter
@Builder
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String name;

    @Column
    @NotNull
    private BigDecimal price;

}
