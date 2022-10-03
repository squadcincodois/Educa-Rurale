package dao;

import java.util.List;

import model.Aluno;

public interface CRUDD {

	public static void create(Aluno aluno) {
	};

	public static void delete(int alunoid) {
	};

	public static List<Aluno> find(String pesquisa) {
		return null;
	}

	public static Aluno findByPk(int alunoid) {
		return null;
	}

	public static void update(Aluno aluno) {
	}
}
