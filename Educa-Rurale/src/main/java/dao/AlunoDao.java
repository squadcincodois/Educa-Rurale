package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Aluno;

public class AlunoDao implements CRUDD {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;

	public static void create(Aluno aluno) {
		sql = "INSERT INTO alunos VALUES (null, ?, ?, ? , ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, aluno.getNome());
			preparedStatement.setString(2, aluno.getTelefone());
			preparedStatement.setString(3, aluno.getIdade());
			preparedStatement.setString(4, aluno.getEndereco());
			preparedStatement.setString(5, aluno.getCpf());

			preparedStatement.executeUpdate();

			System.out.println("Inserção executada no Banco de Dados");

		} catch (SQLException e) {
			System.out.println("A inserção não foi executada no Banco de Dados. " + e.getMessage());
		}
	}

	public static void delete(int alunoid) {
		sql = "DELETE FROM alunos WHERE id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, alunoid);
			preparedStatement.executeUpdate();

			System.out.println("--Aluno deletado com sucesso");

		} catch (SQLException e) {
			System.out.println("--O Aluno não foi deletado " + e.getMessage());
		}
	}

	public static List<Aluno> find(String pesquisa) {

		sql = String.format("SELECT * FROM alunos WHERE nome like '%s%%' OR cpf LIKE '%s%%' ", pesquisa, pesquisa);
		List<Aluno> alunos = new ArrayList<Aluno>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				Aluno aluno = new Aluno();

				aluno.setId(resultSet.getInt("id"));
				aluno.setNome(resultSet.getString("nome"));
				aluno.setTelefone(resultSet.getString("telefone"));
				aluno.setIdade(resultSet.getString("idade"));
				aluno.setEndereco(resultSet.getString("endereco"));
				aluno.setCpf(resultSet.getString("cpf"));

				alunos.add(aluno);

			}

			System.out.println("--Busca de Alunos está correta");
			return alunos;

		} catch (SQLException e) {
			System.out.println("--Busca de Alunos está incorreta " + e.getMessage());
			return null;
		}

	}

	public static Aluno findByPk(int alunoid) {
		sql = String.format("SELECT * FROM alunos WHERE id = %d ", alunoid);

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Aluno aluno = new Aluno();

			while (resultSet.next()) {
				aluno.setId(resultSet.getInt("id"));
				aluno.setNome(resultSet.getString("nome"));
				aluno.setTelefone(resultSet.getString("telefone"));
				aluno.setIdade(resultSet.getString("idade"));
				aluno.setEndereco(resultSet.getString("endereco"));
				aluno.setCpf(resultSet.getString("endereco"));

			}

			System.out.println("--Aluno localizado com sucesso");
			return aluno;

		} catch (SQLException e) {

			System.out.println("--O Aluno não foi localizado " + e.getMessage());
			return null;
		}
	}

	public static void update(Aluno aluno) {
		sql = "UPDATE alunos SET nome=?, telefone=?, idade=?, endereco=?, cpf=?   WHERE id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, aluno.getNome());
			preparedStatement.setString(2, aluno.getTelefone());
			preparedStatement.setString(3, aluno.getIdade());
			preparedStatement.setString(4, aluno.getEndereco());
			preparedStatement.setString(5, aluno.getCpf());
			preparedStatement.setInt(6, aluno.getId());

			preparedStatement.executeUpdate();

			System.out.println("--Atualização realizada no banco de dados");

		} catch (SQLException e) {
			System.out.println("--Atualização não foi realizada no banco de dados " + e.getMessage());
		}
	}
}
