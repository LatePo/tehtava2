package backend.thyme.s23Tunti2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import backend.thyme.s23Tunti2.domain.Friend;
import backend.thyme.s23Tunti2.domain.Student;

@Controller
public class s23StudentController {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/hello")/*heittomerkeissä oleva on hakukenttään kirjoitettava termi*/
	public String greeting(@RequestParam(name="nimi", required = false, defaultValue = "Lauri") String name,@RequestParam(name="ika", required = false, defaultValue = "0") String age, Model model) {
	model.addAttribute("name", name); //heittomerkeissä thymeleaf muuttuja
	model.addAttribute("age", age);
	return "hello";
	}
	
	@GetMapping("/studentlist")
	public String studentList(Model model) {
		List<Student> oppilaat = new ArrayList<Student>();
		oppilaat.add(new Student("Kate", "Cole"));
		oppilaat.add(new Student("Dan", "Brown"));
		oppilaat.add(new Student("Mike", "Mars"));
		model.addAttribute("students", oppilaat);
		return "studentList";
	}
	
	List<Friend> kaverit = new ArrayList<Friend>();
	@GetMapping("/friendlist")
	public String friend(Model model) {
		model.addAttribute("friend", new Friend());
		model.addAttribute("friends", kaverit);
		return "friend";
	}

	@PostMapping("/friendlist")
	public String addFriend(@ModelAttribute Friend friend, Model model) {
		kaverit.add(friend);
		model.addAttribute("friends", kaverit);
		return "friend";
	}
	
}
