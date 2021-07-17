package com.babor.springbootall;

import com.babor.springbootall.domain.Course;
import com.babor.springbootall.repo.CourseRepository;
import com.babor.springbootall.view.CourseView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DebuggingTest {

    @Autowired
    private CourseRepository courseRepository;

    /**
     * Common Mistakes, Uncomment to debug
     *
     * Courses persisted to H2 in-Memory database at startup.
     * @see SpringbootallApplication
     */
    @Test
    public void runtimeErrors() {

        Course course = courseRepository.findByDepartmentName("Sciences");

        CourseView view = courseRepository.getCourseViewByName("English 101").get();
        view = courseRepository.getCourseViewByName("English 101").orElseThrow();
        view = courseRepository.getCourseViewByName("English 100").orElse(
                new CourseView("demon Course", "demon instructor", "dummy department")
        );

    }


}
