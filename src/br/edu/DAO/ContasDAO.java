package br.edu.DAO;

import br.edu.modelo.Conta;
import br.edu.modelo.ContaCorrente;
import br.edu.modelo.ContaPoupanca;

import java.sql.*;
import java.util.ArrayList;

public class ContasDAO extends DAO{
    private final String DELETE = "DELETE FROM conta WHERE numero_conta = ?";

    public void salvar(Conta conta) throws Exception{
        try {
            abrirBanco();
            String inserir = "INSERT INTO conta (numero_conta, agencia, saldo, tipo_conta, id_cliente) " +
                    "VALUES (?, ?, ?, ?, null)";
            pst = (PreparedStatement) con.prepareStatement(inserir);
            pst.setInt(1, conta.getNumero());
            pst.setString(2, conta.getAgencia());
            pst.setDouble(3, conta.getSaldo());
            pst.setString(4, "POUPANCA");
            pst.executeUpdate();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }

    public ArrayList<Conta> buscarPorNumero(int numeroConta) throws Exception {
        ArrayList<Conta> contas = new ArrayList<>();

        try {
             abrirBanco();
             String buscar_por_numero = "SELECT * FROM conta WHERE numero_conta = ?";
            pst = (PreparedStatement) con.prepareStatement(buscar_por_numero);
            pst.setInt(1, numeroConta);

            try {
                while (rs.next()) {
                    String tipoConta = rs.getString("tipo_conta");
                    Conta conta = null;

                    if ("CORRENTE".equalsIgnoreCase(tipoConta)) {
                        conta = new ContaCorrente(
                                rs.getInt("numero_conta"),
                                rs.getString("agencia"),
                                rs.getDouble("saldo"),
                                rs.getDouble("limite"),
                                rs.getDate("data_vencimento").toLocalDate()
                        );
                    } else if ("POUPANCA".equalsIgnoreCase(tipoConta)) {
                        conta = new ContaPoupanca(
                                rs.getInt("numero_conta"),
                                rs.getString("agencia"),
                                rs.getDouble("saldo"),
                                rs.getDouble("taxa_rendimento")
                        );
                    }

                    if (conta != null) {
                        contas.add(conta);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar conta: " + e.getMessage(), e);
        }
        return contas;
    }


    public void atualizarSaldo(Conta conta) {
        try {
            abrirBanco();
            String atualizarSaldo = "UPDATE conta SET saldo = ? WHERE numero_conta = ?";
            pst = (PreparedStatement) con.prepareStatement(atualizarSaldo);
            pst.setInt(1, conta.getNumero());
            pst.setDouble(2, conta.getSaldo());
            pst.executeUpdate();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }

    public void deletarConta(Conta conta) throws Exception{
        abrirBanco();
        String query = "delete from conta where numero_conta=?";
        pst=(PreparedStatement) con.prepareStatement(query);
        pst.setInt(1, conta.getNumero());
        pst.execute();
        System.out.println("Conta deletada com sucesso!");
        fecharBanco();
    }
}
