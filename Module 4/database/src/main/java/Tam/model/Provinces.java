package Tam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "provines")
public class Provinces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    private String name;



}
