package br.usjt.hellospringboot.model;

import org.junit.Assert;
import org.junit.Test;

public class AlunoTest {

	@Test
	public void alunoTest() {
		Aluno a = new Aluno();
		a.setId(1L);
		Assert.assertEquals(1L, a.getId(), 0);
	}
}
