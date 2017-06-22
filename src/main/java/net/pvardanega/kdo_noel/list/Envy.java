package net.pvardanega.kdo_noel.list;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

import static lombok.AccessLevel.PROTECTED;

@Embeddable
@Table(name = "envies")
@Getter
@NoArgsConstructor(access = PROTECTED)
class Envy {
    @NotBlank
    private String title;
    private String subtitle;
    @Column(length = 2048)
    private String imageUrl;
    @Column(length = 2048)
    private String content;
}
