package hs.springboot.example.api;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "One")
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="sample")
    private String sample;
    @Column(name="account")
    private String account;
}
