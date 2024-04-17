package com.leaper.board;

import com.leaper.board.data.entity.Question;
import com.leaper.board.data.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BoardApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa() {
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);

		Question q2 = new Question();
		q2.setSubject("쏜애플은 어떤 밴드인가요?");
		q2.setContent("쏜애플의 노래들은 다 신나나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}

	@Test
	void testFindAll() {
		List<Question> all = this.questionRepository.findAll();
		assertEquals(8, all.size());

		Question q = all.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
	}

	@Test
	void testFirstId() {
		Optional<Question> op = this.questionRepository.findById(1L);
		if (op.isPresent()) {
			Question q = op.get();
			assertEquals("sbb가 무엇인가요?", q.getSubject());
		}
	}

}
