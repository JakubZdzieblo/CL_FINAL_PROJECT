package pl.coderslab.service;


import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Platform;
import pl.coderslab.entity.User;
import pl.coderslab.repository.PlatformRepository;
import pl.coderslab.repository.UserRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DBPopulatePlatforms {

    @Autowired
    PlatformRepository platformRepository;

    @Autowired
    UserRepository userRepository;

    static String jsonString = "[\n" +
            "{\n" +
            "\"abbreviation\": \"AMI\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-1/\",\n" +
            "\"gbId\": 1,\n" +
            "\"name\": \"Amiga\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/amiga/3045-1/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"GB\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-3/\",\n" +
            "\"gbId\": 3,\n" +
            "\"name\": \"Game Boy\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/game-boy/3045-3/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"GBA\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-4/\",\n" +
            "\"gbId\": 4,\n" +
            "\"name\": \"Game Boy Advance\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/game-boy-advance/3045-4/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"SNES\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-9/\",\n" +
            "\"gbId\": 9,\n" +
            "\"name\": \"Super Nintendo Entertainment System\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/super-nintendo-entertainment-system/3045-9/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"C64\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-14/\",\n" +
            "\"gbId\": 14,\n" +
            "\"name\": \"Commodore 64\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/commodore-64/3045-14/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"MAC\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-17/\",\n" +
            "\"gbId\": 17,\n" +
            "\"name\": \"Mac\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/mac/3045-17/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"PSP\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-18/\",\n" +
            "\"gbId\": 18,\n" +
            "\"name\": \"PlayStation Portable\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/playstation-portable/3045-18/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"PS2\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-19/\",\n" +
            "\"gbId\": 19,\n" +
            "\"name\": \"PlayStation 2\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/playstation-2/3045-19/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"X360\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-20/\",\n" +
            "\"gbId\": 20,\n" +
            "\"name\": \"Xbox 360\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/xbox-360/3045-20/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"NES\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-21/\",\n" +
            "\"gbId\": 21,\n" +
            "\"name\": \"Nintendo Entertainment System\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/nintendo-entertainment-system/3045-21/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"PS1\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-22/\",\n" +
            "\"gbId\": 22,\n" +
            "\"name\": \"PlayStation\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/playstation/3045-22/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"A800\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-24/\",\n" +
            "\"gbId\": 24,\n" +
            "\"name\": \"Atari 8-bit\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/atari-8-bit/3045-24/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"XBOX\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-32/\",\n" +
            "\"gbId\": 32,\n" +
            "\"name\": \"Xbox\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/xbox/3045-32/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"PS3\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-35/\",\n" +
            "\"gbId\": 35,\n" +
            "\"name\": \"PlayStation 3\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/playstation-3/3045-35/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"Wii\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-36/\",\n" +
            "\"gbId\": 36,\n" +
            "\"name\": \"Wii\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/wii/3045-36/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"N64\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-43/\",\n" +
            "\"gbId\": 43,\n" +
            "\"name\": \"Nintendo 64\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/nintendo-64/3045-43/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"PC\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-94/\",\n" +
            "\"gbId\": 94,\n" +
            "\"name\": \"PC\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/pc/3045-94/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"3DS\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-117/\",\n" +
            "\"gbId\": 117,\n" +
            "\"name\": \"Nintendo 3DS\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/nintendo-3ds/3045-117/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"VITA\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-129/\",\n" +
            "\"gbId\": 129,\n" +
            "\"name\": \"PlayStation Vita\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/playstation-vita/3045-129/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"WiiU\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-139/\",\n" +
            "\"gbId\": 139,\n" +
            "\"name\": \"Wii U\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/wii-u/3045-139/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"XONE\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-145/\",\n" +
            "\"gbId\": 145,\n" +
            "\"name\": \"Xbox One\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/xbox-one/3045-145/\"\n" +
            "},\n" +
            "{\n" +
            "\"abbreviation\": \"PS4\",\n" +
            "\"api_detail_url\": \"https://www.giantbomb.com/api/platform/3045-146/\",\n" +
            "\"gbId\": 146,\n" +
            "\"name\": \"PlayStation 4\",\n" +
            "\"site_detail_url\": \"https://www.giantbomb.com/playstation-4/3045-146/\"\n" +
            "}\n" +
            "]";

    public DBPopulatePlatforms() {
    }

    public void DBPopulatePlatforms() {

        List<Platform> resultList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        String jsonInString = new String(jsonString);
        try {
            resultList = mapper.readValue(jsonInString, new TypeReference<List<Platform>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Platform plat : resultList) {
            platformRepository.save(plat);
        }
    }

    public void DBCreateUser() {
        User user = new User();
        user.setLogin("jdoe");
        user.setPassword(BCrypt.hashpw("12345", BCrypt.gensalt()));
        user.setEmail("jd@mail.com");
        user.setComments(new ArrayList<>());
        user.setGames(new ArrayList<>());
        user.setName("John Doe");
        userRepository.save(user);

        User user2 = new User();
        user2.setLogin("kub");
        user2.setPassword(BCrypt.hashpw("12345", BCrypt.gensalt()));
        user2.setEmail("k@mail.com");
        user2.setComments(new ArrayList<>());
        user2.setGames(new ArrayList<>());
        user2.setName("Kub Bub");
        userRepository.save(user2);
    }


}
