package br.com.etec.IsaacNatanael.Caronas.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@Entity
@Table(name = "TBL_Carona")
public class Carona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int IdCarona;
    @Column(name = "TX_NomeMotorista")
    private String NomeMotorista;
    @Column(name = "TX_BairroOrigem")
    private String BairroOrigem;
    @Column(name = "TX_HorarioSaida")
    private String HorarioSaida;
    @Column(name = "NR_VagasDisponiveis")
    private int VagasDisponiveis;
    @Column(name = "TX_Status")
    private String Status;


}
