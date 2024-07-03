package hs.sample.step1.v3.controller.sample;

import java.util.Map;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("/sample")
//    public String sample(Map<String, Object> model) {
    public String sample(Model model) {

//        model.put("sample", "sample");
        // Mockup 데이터 생성
        Member member = new Member();
        member.setId(999_999_999L);
        member.setEmail("sample@example.com");
        member.setName("홍길동");
        // ... 기본 정보, 개인정보, 주소 정보 설정
        member.setGender("Male");
        member.setBirthDate("1990-10-20");
        member.setPhone("010-1111-2222");

        member.setAddress("서울특별시 영등포구 여의대로 17");

        // Model에 데이터 설정
        model.addAttribute("member", member);

        return "/app/sample/sample";
    }

    @GetMapping("/sample-regist")
    public String sampleRegist(Map<String, Object> model) {
        model.put("sample", "sample");
        return "/app/sample/sample-regist";
    }

    @Setter
    class Member {

        private Long id;
        private String email;
        private String name;
        // ... 기본 정보 그룹의 다른 필드 추가

        private String gender;
        private String birthDate;
        private String phone;
        // ... 개인정보 그룹의 다른 필드 추가

        private String address;
        // ... 주소 정보 그룹의 다른 필드 추가

        // getter, setter 등...
    }

}
