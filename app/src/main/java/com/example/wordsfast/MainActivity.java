package com.example.wordsfast;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private String[] WORD_ENG_ARRAY = {"To be", "To do", "To feel", "To see", "To hear", "To run", "To get", "To make", "To cook", "To sing", "To speak", "To say", "To tell", "To take", "To sit", "To stand", "To laugh", "To smile", "To open", "To close", "To love", "To like", "To give", "To bring", "To breath", "To buy", "To sell", "To forget", "To believe", "To have", "To go", "To know", "To think", "To come", "To want", "To use", "To find", "To work", "To eat", "To drink", "To write", "To read", "To call", "To try", "To need", "To become", "To put", "To leave", "To pay", "To play", "To pray", "To stay", "To mean", "To keep", "To let", "To begin", "To start", "To finish", "To help", "To show", "To cry", "To move", "To jump", "To live", "To die", "To happen", "To lose", "To hate", "To include", "To turn on", "To turn off", "To continue", "To change", "To wash", "To clean", "To lead", "To understand", "To watch", "To discover", "To imagine", "To introduce", "To follow", "To create", "To grow", "To spend", "To win", "To offer", "To learn", "To appear", "To disappear", "To build", "To break", "To send", "To fall", "To cut", "To achieve", "To communicate", "To kill", "To pass", "To fly", "To swim", "To decide", "To return", "To hope", "To explain", "To propose", "To develop", "To support", "To dance", "To draw", "To book", "To be afraid", "To agree", "To check up", "To delete", "To choose", "To catch", "To ask", "To answer", "To hesitate", "air", "wind", "water", "west", "east", "north", "south", "tree", "sea", "ocean", "rock", "plant", "flower", "forest", "person", "night", "morning", "day", "evening", "life", "mountain", "land", "house", "fire", "country", "animal", "bird", "fish", "insect", "city", "world", "boy", "girl", "mother", "father", "son", "daughter", "baby", "family", "grand mother", "grand father", "children", "home", "love", "apartment", "joy", "nephew", "aunt", "uncle", "cousin", "man", "woman", "child", "sister", "brother", "Relatives", "friend", "wife", "husband", "address", "happiness", "People", "phone", "question", "place", "market", "order", "food", "work", "communication", "story", "relax", "time", "word", "dialogue", "meeting", "week", "distance", "club", "theatre", "cinema", "coffee shop", "friendship", "behavior", "attitude", "student", "university", "union", "party", "date", "sweetheart", "leisure time", "road", "ticket", "map", "motel", "highway", "reception", "wallet", "bank", "subway", "cab", "parking", "food order", "cash", "passport", "permission", "lawyer", "problem", "waiting room", "transfer", "bag", "suitcase", "property", "law", "police station", "price", "price list", "courier", "delivery", "location", "route", "agreement", "hospital", "ambulance", "Afraid", "Angry", "Asleep", "Attentive", "Available", "Basic", "Beautiful", "Big", "Brave", "Busy", "Calm", "Careful", "Cheap", "Clean", "Clever", "Cold", "Comfortable", "Confident", "Constant", "Curious", "Dangerous", "Dark", "Deep", "Different", "Difficult", "Dirty", "Easy", "Every", "Expensive", "Exact", "Fast", "Fair", "Fine", "Foreign", "Free", "Fresh", "Full", "Funny", "Guilty", "Healthy", "Hard", "Helpful", "Honest", "Hot", "Hungry", "Important", "Illegal", "Impossible", "Independent", "Interesting", "Kind", "Legal", "Little", "Lucky", "Necessary", "Normal", "Old", "Opposite", "Perfect", "Poor", "Powerful", "Possible", "Quiet", "Rare", "Recent", "Relevant", "Remote", "Safe", "Short", "Small", "Strange", "Successful", "Tasty", "Terrible", "Tired", "Warm", "Weak", "Responsible", "Sad", "International", "Together", "According", "Again", "Always", "Beautifully", "Carefully", "Correctly", "Especially", "Friendly", "Indeed", "Above", "Accidentally", "Actually", "Badly", "Besides", "Briefly", "Certainly", "Daily", "Dreamily", "Even", "Eventually", "Foolishly", "Forward", "Ever", "Equally", "Fortunately", "Honestly", "Instead", "Inside", "Also", "Hardly", "Lately", "Less", "Loudly", "Nearly", "Never", "Only", "Once", "Often", "Perhaps", "Quickly", "Probably", "Rarely", "Really", "Sometimes", "Yesterday", "Thus", "Somehow", "Soon", "Regularly", "Somewhere", "ability", "accident", "action", "actor", "actress", "advertisement", "advice", "airport", "alphabet", "apartment", "appearance", "appointment", "argument", "artist", "assistant", "attention", "audience", "author", "autumn", "background", "balcony", "band", "bath", "bathroom", "battery", "beauty", "behavior", "bicycle", "bill", "biology", "blanket", "blood", "board", "boss", "brain", "branch", "bridge", "breakfast", "building", "bus stop", "businessman", "businesswoman", "calendar", "camera", "cancer", "candidate", "capital", "carpet", "cartoon", "cash", "castle", "ceiling", "celebrity", "century", "ceremony", "champion", "championship", "channel", "charity", "chemistry", "childhood", "choice", "church", "cigarette", "circle", "climate", "closet", "club", "coach", "colleague", "college", "comedy", "competition", "complaint", "concert", "condition", "conference", "confidence", "connection", "contact", "contest", "continent", "conversation", "costume", "countryside", "cousin", "criminal", "culture", "currency", "customer", "damage", "danger", "database", "decade", "decision", "degree", "department", "design", "dessert", "detail", "diary", "dictionary", "diet", "difficulty", "direction", "disaster", "discovery", "disease", "distance", "document", "drama", "drawing", "dream", "driver", "driving", "economy", "education", "election", "email", "employee", "employer", "energy", "engine", "engineer", "entrance", "environment", "equipment", "error", "event", "evidence", "example", "exchange", "exercise", "exhibition", "exit", "experience", "experiment", "explanation", "factory", "failure", "fan", "farm", "fashion", "fear", "feature", "fence", "fiction", "field", "file", "film", "final", "finger", "fire", "flight", "floor", "flour", "focus", "food", "football", "form", "fortune", "frame", "freedom", "function", "furniture", "gallery", "garage", "garden", "gate", "generation", "gift", "goal", "gold", "golf", "government", "grade", "graduate", "graduation", "grammar", "grass", "guest", "guide", "habit", "hair", "hall", "handbag", "headline", "health", "headline", "headline", "heart", "heat", "height", "hero", "history", "holiday", "home", "homework", "honor", "hospital"};

    private String[] WORD_TRANSCRIPTION = {"[tə biː]", "[du]", "[fiːl]", "[siː]", "[hɪər]", "[rʌn]", "[ɡet]", "[meɪk]", "[kʊk]", "[sɪŋ]", "[spiːk]", "[seɪ]", "[tel]", "[teɪk]", "[sɪt]", "[stænd]", "[lɑːf]", "[smaɪl]", "[ˈəʊpən]", "[kləʊz]", "[lʌv]", "[laɪk]", "[ɡɪv]", "[brɪŋ]", "[breθ]", "[baɪ]", "[sel]", "[fəˈɡet]", "[bɪˈliːv]", "[həv]", "[ɡəʊ]", "[nəʊ]", "[θɪŋk]", "[kʌm]", "[wɒnt]", "[juːz]", "[faɪnd]", "[wɜːk]", "[iːt]", "[drɪŋk]", "[raɪt]", "[riːd]", "[kɔːl]", "[traɪ]", "[niːd]", "[bɪˈkʌm]", "[pʊt]", "[liːv]", "[peɪ]", "[pleɪ]", "[preɪ]", "[steɪ]", "[miːn]", "[kiːp]", "[let]", "[bɪˈɡɪn]", "[stɑːt]", "[ˈfɪnɪʃ]", "[help]", "[ʃəʊ]", "[kraɪ]", "[muːv]", "[dʒʌmp]", "[lɪv]", "[daɪ]", "[ˈhæpən]", "[luːz]", "[heɪt]", "[ɪnˈkluːd]", "[tɜːn ɒn]", "[tɜːn ɒf]", "[kənˈtɪnjuː]", "[tʃeɪndʒ]", "[wɒʃ]", "[kliːn]", "[liːd]", "[ˌʌndəˈstænd]", "[wɒtʃ]", "[dɪˈskʌvə(r)]", "[ɪˈmædʒɪn]", "[ˌɪntrəˈdjuːs]", "[ˈfɒləʊ]", "[kriˈeɪt]", "[ɡrəʊ]", "[spend]", "[wɪn]", "[ˈɒfə(r)]", "[lɜːn]", "[əˈpɪə(r)]", "[ˌdɪsəˈpɪə(r)]", "[bɪld]", "[breɪk]", "[send]", "[fɔːl]", "[kʌt]", "[əˈtʃiːv]", "[kəˈmjuːnɪkeɪt]", "[kɪl]", "[pɑːs]", "[flaɪ]", "[swɪm]", "[dɪˈsaɪd]", "[rɪˈtɜːn]", "[həʊp]", "[ɪkˈspleɪn]", "[prəˈpəʊz]", "[dɪˈveləp]", "[səˈpɔːt]", "[dɑːns]", "[drɔː]", "[bʊk]", "[bi əˈfreɪd]", "[əˈɡriː]", "[tʃek ʌp]", "[dɪˈliːt]", "[tʃuːz]", "[kætʃ]", "[ɑːsk]", "[ˈɑːnsə(r)]", "[ˈhezɪteɪt]", "[ən eə(r)]", "[wɪnd]", "[ˈwɔːtə(r)]", "[west]", "[iːst]", "[nɔːθ]", "[saʊθ]", "[triː]", "[siː]", "[ˈəʊʃn]", "[rɒk]", "[plɑːnt]", "[ˈflaʊə(r)]", "[ˈfɒrɪst]", "[ˈpɜːsn]", "[naɪt]", "[ˈmɔːnɪŋ]", "[deɪ]", "[ˈiːvnɪŋ]", "[laɪf]", "[ˈmaʊntən]", "[lænd]", "[haʊs]", "[ˈfaɪə(r)]", "[ˈkʌntri]", "[ˈænɪml]", "[bɜːd]", "[fɪʃ]", "[ˈɪnsekt]", "[ˈsɪti]", "[wɜːld]", "Мальчик", "Девочка", "Мама", "Отец", "Сын", "Дочь", "Малыш", "Семья", "Бабушка", "Дедушка", "Дети", "Дом", "Любовь", "Квартира", "Радость", "Племянник", "Тетя", "Дядя", "Двоюродная сестра или брат", "Мужчина", "Женщина", "Ребенок", "Сестра", "Брат", "Родственники", "Друг", "Жена", "Муж", "Адрес", "Счастье", "Люди", "[fəʊn]", "[ˈkwestʃən]", "[pleɪs]", "[ˈmɑːkɪt]", "[ˈɔːdə(r)]", "[fuːd]", "[wɜːk]", "[kəˌmjuːnɪˈkeɪʃn]", "[ˈstɔːri]", "[rɪˈlæks]", "[taɪm]", "[wɜːd]", "[ˈdaɪ.ə.lɒɡ]", "[ˈmiːtɪŋ]", "[wiːk]", "[ˈdɪstəns]", "[klʌb]", "[ˈθɪətə(r)]", "[ˈsɪnəmə]", "[ˈkɒfi ʃɒp]", "[ˈfrendʃɪp]", "[bɪˈheɪ.vjər]", "[ˈætɪtjuːd]", "[ˈstjuːdnt]", "[ˌjuːnɪˈvɜːsəti]", "[ˈjuːniən]", "[ˈpɑːti]", "[deɪt]", "[ˈswiːt.hɑːt]", "[ˈleʒ.ər taɪm]", "[rəʊd]", "[ˈtɪkɪt]", "[mæp]", "[məʊˈtel]", "[ˈhaɪweɪ]", "[rɪˈsepʃn]", "[ˈwɒlɪt]", "[bæŋk]", "[ˈsʌb.weɪ]", "[kæb]", "[ˈpɑː.kɪŋ]", "[fuːd ˈɔːdə(r)]", "[kæʃ]", "[ˈpɑːspɔːt]", "[pəˈmɪʃn]", "[ˈlɔːjə(r)]", "[ˈprɒbləm]", "[weɪtin: ruːm]", "[trænsˈfɜː(r)]", "[bæɡ]", "[ˈsuːtkeɪs]", "[ˈprɒpəti]", "[lɔː]", "[pəˈliːs ˈsteɪʃn]", "[praɪs]", "[praɪs lɪst]", "[ˈkʊr.i.ər]", "[dɪˈlɪvəri]", "[ləʊˈkeɪʃn]", "[ruːt]", "[əˈɡriːmənt]", "[ˈhɒspɪtl]", "[ˈæmbjələns]", "[əˈfreɪd]", "[ˈæŋɡri]", "[əˈsliːp]", "[əˈten.tɪv]", "[əˈveɪləbl]", "[ˈbeɪsɪk]", "[ˈbjuːtɪfl]", "[bɪɡ]", "[breɪv]", "[ˈbɪzi]", "[kɑːm]", "[ˈkeəfl]", "[tʃiːp]", "[kliːn]", "[ˈklevə(r)]", "[kəʊld]", "[ˈkʌmftəbl]", "[ˈkɒnfɪdənt]", "[ˈkɒnstənt]", "[ˈkjʊəriəs]", "[ˈdeɪndʒərəs]", "[dɑːk]", "[diːp]", "[ˈdɪfrənt]", "[ˈdɪfɪkəlt]", "[ˈdɜːti]", "[ˈiːzi]", "[ˈevri]", "[ɪkˈspensɪv]", "[ɪɡˈzækt]", "[fɑːst]", "[feə(r)]", "[faɪn]", "[ˈfɒrən]", "[friː]", "[freʃ]", "[fʊl]", "[ˈfʌni]", "[ˈɡɪlti]", "[ˈhelθi]", "[hɑːd]", "[ˈhelpfl]", "[ˈɒnɪst]", "[hɒt]", "[ˈhʌŋɡri]", "[ɪmˈpɔːtnt]", "[ɪˈliːɡl]", "[ɪmˈpɒsəbl]", "[ˌɪndɪˈpendənt]", "[ˈɪntrəstɪŋ]", "[kaɪnd]", "[ˈliːɡl]", "[ˈlɪtl]", "[ˈlʌki]", "[ˈnesəsəri]", "[ˈnɔːml]", "[əʊld]", "[ˈɒpəzɪt]", "[pəˈfekt]", "[pɔː(r)]", "[ˈpaʊəfl]", "[ˈpɒsəbl]", "[ˈkwaɪət]", "[reə(r)]", "[ˈriːsnt]", "[ˈreləvənt]", "[rɪˈməʊt]", "[seɪf]", "[ʃɔːt]", "[smɔːl]", "[streɪndʒ]", "[səkˈsesfl]", "[ˈteɪ.sti]", "[ˈterəbl]", "[ˈtaɪəd]", "[wɔːm]", "[wiːk]", "[rɪˈspɒnsəbl]", "[sæd]", "[ˌɪntəˈnæʃnəl]", "[təˈɡeðə(r)]", "[əˈkɔːdɪŋ]", "[əˈɡen]", "[ˈɔːlweɪz]", "[ˈbjuːtɪfli]", "[ˈkeə.fəl.i]", "[kəˈrektli]", "[ɪˈspeʃəli]", "[ˈfrendli]", "[ɪnˈdiːd]", "[əˈbʌv]", "[ˌæk.sɪˈden.təl.i]", "[ˈæktʃuəli]", "[ˈbædli]", "[bɪˈsaɪdz]", "[ˈbriːfli]", "[ˈsɜːtnli]", "[ˈdeɪli]", "[ˈdriː.mɪ.li]", "[ˈiːvn]", "[ɪˈventʃuəli]", "[ˈfuːlɪʃli]", "[ˈfɔːwəd]", "[ˈevə(r)]", "[ˈiːkwəli]", "[ˈfɔː.tʃən.ət.li]", "[ˈɒnɪstli]", "[ɪnˈsted]", "[ˌɪnˈsaɪd]", "[ˈɔːlsəʊ]", "[ˈhɑːdli]", "[ˈleɪt.li]", "[les]", "[ˈlaʊd.li]", "[ˈnɪəli]", "[ˈnevə(r)]", "[ˈəʊnli]", "[wʌns]", "[ˈɒfn]", "[pəˈhæps]", "[ˈkwɪkli]", "[ˈprɒbəbli]", "[ˈreəli]", "[ˈriːəli]", "[ˈsʌmtaɪmz]", "[ˈjestədeɪ]", "[ðʌs]", "[ˈsʌmhaʊ]", "[suːn]", "[ˈreɡjələli]", "[ˈsʌmweə(r)]", "[əˈbɪləti]", "[ˈæksɪdənt]", "[ˈækʃən]", "[ˈæktər]", "[ˈæktrəs]", "[ədˈvɜːtɪsmənt]", "[ədˈvaɪs]", "[ˈeəpɔːt]", "[ˈælfəbet]", "[əˈpɑːtmənt]", "[əˈpɪərəns]", "[əˈpɔɪntmənt]", "[ˈɑːɡjəmənt]", "[ˈɑːtɪst]", "[əˈsɪstənt]", "[əˈtenʃən]", "[ˈɔːdiəns]", "[ˈɔːθər]", "[ˈɔːtəm]", "[ˈbækɡraʊnd]", "[ˈbælkəni]", "[bænd]", "[bɑːθ]", "[ˈbɑːθruːm]", "[ˈbætəri]", "[ˈbjuːti]", "[bɪˈheɪvjɚ]", "[ˈbaɪsɪkəl]", "[bɪl]", "[baɪˈɒlədʒi]", "[ˈblæŋkɪt]", "[blʌd]", "[bɔːd]", "[bɒs]", "[breɪn]", "[brɑːntʃ]", "[brɪdʒ]", "[ˈbrekfəst]", "[ˈbɪldɪŋ]", "[ˈbʌs ˌstɒp]", "[ˈbɪznɪsmən]", "[ˈbɪznɪsˌwʊmən]", "[ˈkæləndər]", "[ˈkæmrə]", "[ˈkænsər]", "[ˈkændɪdət]", "[ˈkæpɪtəl]", "[ˈkɑːpɪt]", "[kɑːˈtuːn]", "[kæʃ]", "[ˈkɑːsəl]", "[ˈsiːlɪŋ]", "[səˈlebrəti]", "[ˈsentʃəri]", "[ˈserɪməni]", "[ˈtʃæmpiən]", "[ˈtʃæmpiənʃɪp]", "[ˈtʃænəl]", "[ˈtʃærəti]", "[ˈkemɪstri]", "[ˈtʃaɪldhʊd]", "[tʃɔɪs]", "[tʃɜːtʃ]", "[ˌsɪɡərˈet]", "[ˈsɜːkəl]", "[ˈklaɪmət]", "[ˈklɒzɪt]", "[klʌb]", "[kəʊtʃ]", "[ˈkɒliːɡ]", "[ˈkɒlɪdʒ]", "[ˈkɒmədi]", "[ˌkɒmpəˈtɪʃən]", "[kəmˈpleɪnt]", "[ˈkɒnsət]", "[kənˈdɪʃən]", "[ˈkɒnfərəns]", "[ˈkɒnfɪdəns]", "[kəˈnekʃən]", "[ˈkɒntækt]", "[ˈkɒntest]", "[ˈkɒntɪnənt]", "[ˌkɒnvəˈseɪʃən]", "[ˈkɒstʃuːm]", "[ˈkʌntrisaɪd]", "[ˈkʌzən]", "[ˈkrɪmɪnəl]", "[ˈkʌltʃər]", "[ˈkʌrənsi]", "[ˈkʌstəmər]", "[ˈdæmɪdʒ]", "[ˈdeɪndʒər]", "[ˈdeɪtəbeɪs]", "[ˈdekeɪd]", "[dɪˈsɪʒən]", "[dɪˈɡriː]", "[dɪˈpɑːtmənt]", "[dɪˈzaɪn]", "[dɪˈzɜːt]", "[ˈdiːteɪl]", "[ˈdaɪəri]", "[ˈdɪkʃənəri]", "[ˈdaɪət]", "[ˈdɪfɪkəlti]", "[daɪˈrekʃən]", "[dɪˈzɑːstər]", "[dɪˈskʌvəri]", "[dɪˈziːz]", "[ˈdɪstəns]", "[ˈdɒkjəmənt]", "[ˈdrɑːmə]", "[ˈdrɔːɪŋ]", "[driːm]", "[ˈdraɪvər]", "[ˈdraɪvɪŋ]", "[iˈkɒnəmi]", "[ˌedʒʊˈkeɪʃən]", "[iˈlekʃən]", "[ˈiːmeɪl]", "[ɪmˈplɔɪiː]", "[ɪmˈplɔɪər]", "[ˈenədʒi]", "[ˈendʒɪn]", "[ˌendʒɪˈnɪər]", "[ˈentrəns]", "[ɪnˈvaɪrəmənt]", "[ɪˈkwɪpmənt]", "[ˈerər]", "[ɪˈvent]", "[ˈevɪdəns]", "[ɪɡˈzɑːmpəl]", "[ɪksˈtʃeɪndʒ]", "[ˈeksəsaɪz]", "[ˌeksɪˈbɪʃən]", "[ˈeksɪt]", "[ɪkˈspɪəriəns]", "[ɪkˈsperɪmənt]", "[ˌekspləˈneɪʃən]", "[ˈfæktəri]", "[ˈfeɪljər]", "[fæn]", "[fɑːm]", "[ˈfæʃən]", "[fɪər]", "[ˈfiːtʃər]", "[fens]", "[ˈfɪkʃən]", "[fiːld]", "[faɪl]", "[fɪlm]", "[ˈfaɪnəl]", "[ˈfɪŋɡər]", "[faɪər]", "[flaɪt]", "[flɔːr]", "[flaʊər]", "[ˈfəʊkəs]", "[fuːd]", "[ˈfʊtbɔːl]", "[fɔːm]", "[ˈfɔːtʃuːn]", "[freɪm]", "[ˈfriːdəm]", "[ˈfʌŋkʃən]", "[ˈfɜːnɪtʃər]", "[ˈɡæləri]", "[ˈɡærɑːʒ]", "[ˈɡɑːdən]", "[ɡeɪt]", "[ˌdʒenəˈreɪʃən]", "[ɡɪft]", "[ɡəʊl]", "[ɡəʊld]", "[ɡɒlf]", "[ˈɡʌvəmənt]", "[ɡreɪd]", "[ˈɡrædʒuət]", "[ˌɡrædʒuˈeɪʃən]", "[ˈɡræmər]", "[ɡrɑːs]", "[ɡest]", "[ɡaɪd]", "[ˈhæbɪt]", "[heər]", "[hɔːl]", "[ˈhændbæɡ]", "[ˈhedlaɪn]", "[helθ]", "[ˈhedlaɪn]", "[ˈhedlaɪn]", "[hɑːt]", "[hiːt]", "[haɪt]", "[ˈhɪərəʊ]", "[ˈhɪstəri]", "[ˈhɒlədeɪ]", "[həʊm]", "[ˈhəʊmwɜːk]", "[ˈɒnər]", "[ˈhɒspɪtəl]"};
    private String[] WORD_UK_ARRAY = {"Бути", "Робити", "Відчувати", "Бачити", "Чути", "Бігти", "Отримувати", "Зробити", "Готувати", "Співати", "Розмовляти", "Говорити", "Розказувати", "Брати", "Сідати", "Стояти", "Сміятися", "Посміхатися", "Відкривати", "Закривати", "Кохати", "Подобатися", "Давати", "Приносити", "Дихати", "Купувати", "Продавати", "Забувати", "Вірити", "Мати", "Іти", "Знати", "Думати", "Приходити", "Бажати", "Використати", "Знаходити", "Працювати", "Є", "Пити", "Писати", "Читати", "Дзвонити", "Намагатися", "Потребувати", "Ставати", "Класти", "Залишати", "Платити", "Грати", "Молитися", "Залишатися", "Означати", "Тримати, зберігати", "Залишати", "Починати", "Стартувати", "Закінчувати", "Допомагати", "Показувати", "Плакати", "Рухатися", "Стрибати", "Жити", "Вмирати", "Траплятися", "Програвати", "Ненавидіти", "Включати в себе", "Включати (про прилад)", "Вимикати", "Продовжувати", "Міняти", "Мити", "Забирати, очищати", "Вести", "Розуміти", "Дивитись", "Дослідити", "Представляти", "Уявити", "Дотримуватися", "Створювати", "Зростати", "Витрачати", "Вигравати", "Пропонувати", "Вивчати", "З'являтися", "Зникати", "Будувати", "Ламати", "Посилати", "Падати", "Різати", "Досягати", "Спілкуватися", "Вбивати", "Проходити", "Літати", "Плавати", "Вирішувати", "Повертатись", "Сподіватися", "Пояснювати", "Пропонувати", "Розвивати", "Підтримувати", "Танцювати", "Малювати", "Бронювати", "Боятися", "Погоджуватися", "Перевіряти", "Вилучати", "Вибирати", "Ловити", "Запитувати", "Відповідати", "Сумніватися", "Повітря", "Вітер", "Вода", "Захід", "Схід", "Північ", "Південь", "Дерево", "Море", "Океан", "Скеля", "Рослина", "Квітка", "Ліс", "Особистість", "Ніч", "Ранок", "День", "Вечір", "Життя", "Гора", "Земля", "Хата", "Вогонь", "Країна", "Тварина", "Птах", "Риба", "Комаха", "Місто", "мир", "[bɔɪ]", "[ɡɜːl]", "[ˈmʌðə(r)]", "[ˈfɑːðə(r)]", "[sʌn]", "[ˈdɔːtə(r)]", "[ˈbeɪbi]", "[ˈfæməli]", "[ɡrænd ˈməTΟHər]", "[ɡrænd ˈfɑːðə(r)]", "[ˈtʃɪl.drən]", "[həʊm]", "[lʌv]", "[əˈpɑːtmənt]", "[dʒɔɪ]", "[ˈnefjuː]", "[ɑːnt]", "[ˈʌŋkl]", "[ˈkʌzn]", "[mæn]", "[ˈwʊmən]", "[tʃaɪld]", "[ˈsɪstə(r)]", "[ˈbrʌðə(r)]", "[ˈrel.ə.tɪv]", "[frend]", "[waɪf]", "[ˈhʌzbənd]", "[əˈdres]", "[ˈhæp.i.nəs]", "[ˈpiːpl]", "Телефон", "Питання", "Місце", "Ринок", "Замовлення", "Їжа", "Робота", "Спілкування", "Історія", "Відпочинок", "Час", "Слово", "Діалог", "Зустріч", "Тиждень", "Дистанція", "Клуб", "Театр", "Кінотеатр", "Кав'ярня", "Дружба", "Поведінка", "Ставлення", "Студент", "Університет", "Об'єднання", "Вечірка", "Побачення", "Партнер, коханий", "Дозвілля", "Дорога", "Квиток", "Карта", "Мотель", "Шосе", "Реєстратура, ресепшн", "Гаманець", "Банк", "Метро", "Таксі", "Паркування", "Замовлення їжі", "Готівка", "Паспорт", "Дозвіл", "Адвокат", "Проблема", "Зал очікування", "Пересадка", "Сумка", "Валіза", "Майно", "Право, закон", "Відділок поліції", "Вартість, ціна", "Цінник", "Кур'єр", "Доставка", "Розташування", "Маршрут", "Договір", "Лікарня", "Швидка допомога", "Наляканий", "Сердитий", "Сплячий", "Уважний", "Доступний", "Базовий", "Вродливий", "Великий", "Сміливий", "Зайнятою", "Спокійний", "Уважний, дбайливий", "Дешевий", "Чистий", "Розумний", "Холодний", "Комфортний", "Впевнений", "Постійний", "Допитливий", "Небезпечний", "Темний", "Глибокий", "Різний", "Важкий", "Брудний", "Легкий", "Кожен", "Дорогий", "Точний", "Швидкий", "Чесний, світлий", "Чудовий", "Іноземний", "Вільний", "Свіжий", "Повний", "Кумедний", "Винний", "Здоровий", "Важкий", "Корисний", "Чесний", "Гарячий", "Голодний", "Важливий", "Нелегальний, незаконний", "Неможливий", "Незалежний", "Цікавий", "Добрий", "Законний", "Маленький", "Удачливий", "Необхідний", "Нормальний", "Старий", "Протилежний", "Ідеальний", "Бідний", "Потужний", "Можливий", "Тихий", "Рідкісний", "Недавній", "Релевантний, актуальний", "Віддалений", "Безпечний", "Короткий", "Маленький", "Дивний, незнайомий, чужий", "Успішний", "Смачний, приємний", "Моторошний", "Втомлений", "Теплий", "Слабкий", "Відповідальний, надійний", "Сумний", "Міжнародний", "Разом", "Відповідно", "Знову", "Завжди", "Гарно", "Обережно", "Правильно, правильно", "Особливо", "Доброзичливо", "Дійсно", "Вище", "Випадково", "Насправді", "Погано", "Крім цього", "Коротко", "звичайно", "Щодня", "Мрійливо", "Навіть", "В кінці кінців", "Дурно", "Вперед", "Коли-небудь", "Так само однаково", "На щастя", "Чесно", "Замість", "Усередині", "Також", "Насилу", "Нещодавно", "Менше", "Гучно, галасливо", "Біля", "Ніколи", "Тільки", "Один раз", "Часто", "можливо", "Швидко", "Ймовірно", "Рідко", "Дійсно", "Іноді", "Вчора", "Таким чином", "Якось", "Скоро", "Регулярно", "Десь", "здатність", "нещасний випадок", "дію", "актор", "актриса", "реклама", "поради", "аеропорт", "алфавіт", "квартира", "зовнішній вигляд", "призначення", "аргумент", "художник", "помічник", "уваги", "аудиторія", "автор", "осінь", "фон", "балкон", "гурт", "ванна", "ванна кімната", "акумулятор", "краса", "поведінка", "велосипед", "рахунок", "біологія", "ковдра", "кров", "дошка", "бос", "мозок", "відділення", "міст", "сніданок", "будівля", "автобусна зупинка", "бізнесмен", "Ділова жінка", "календар", "камера", "рак", "кандидат", "капітал", "килим", "мультфільм", "готівкою", "замок", "стеля", "знаменитість", "століття", "церемонія", "чемпіон", "першість", "канал", "благодійність", "хімія", "дитинство", "вибір", "церква", "сигарета", "коло", "клімат", "шафа", "клуб", "тренер", "колега", "коледж", "комедія", "змагання", "скарга", "концерт", "хвороба", "конференції", "впевненість", "підключення", "контакт", "конкурс", "континент", "розмова", "костюм", "сільська місцевість", "двоюрідний брат", "кримінальний", "культури", "валюта", "клієнт", "пошкодження", "небезпека", "бази даних", "десятиліття", "рішення", "ступінь", "відділ", "дизайн", "десерт", "деталь", "щоденник", "словник", "дієта", "труднощі", "напрямок", "катастрофа", "відкриття", "захворювання", "відстань", "документ", "драма", "малювання", "мрія", "водій", "водіння", "економіка", "освіти", "вибори", "електронною поштою", "працівник", "роботодавець", "енергії", "двигун", "інженер", "вхід", "навколишнє середовище", "обладнання", "помилка", "подія", "докази", "приклад", "обмін", "вправи", "виставка", "вихід", "досвід", "експеримент", "пояснення", "фабрика", "невдача", "вентилятор", "ферма", "мода", "страх", "функція", "паркан", "художня література", "поле", "файл", "фільм", "остаточний", "палець", "вогонь", "політ", "поверх", "борошно", "фокус", "харчування", "футбол", "форму", "доля", "рамка", "свобода", "функція", "меблі", "галерея", "гараж", "сад", "ворота", "покоління", "подарунок", "мета", "золото", "гольф", "уряд", "клас", "випускник", "градація", "граматика", "трава", "гість", "керівництво", "звичка", "волосся", "зал", "сумочка", "заголовок", "здоров'я", "заголовок", "заголовок", "серце", "тепло", "висота", "герой", "історії", "свято", "додому", "Домашня робота", "честь", "лікарня"};

    private String[] NAME_IMAGES = {"to_be", "to_do", "to_feel", "to_see", "to_hear", "to_run", "to_get", "to_make", "to_cook", "to_sing", "to_speak", "to_say", "to_tell", "to_take", "to_sit", "to_stand", "to_laugh", "to_smile", "to_open", "to_close", "to_love", "to_like", "to_give", "to_bring", "to_breath", "to_buy", "to_sell", "to_forget", "to_believe", "to_have", "to_go", "to_know", "to_think", "to_come", "to_want", "to_use", "to_find", "to_work", "to_eat", "to_drink", "to_write", "to_read", "to_call", "to_try", "to_need", "to_become", "to_put", "to_leave", "to_pay", "to_play", "to_pray", "to_stay", "to_mean", "to_keep", "to_let", "to_begin", "to_start", "to_finish", "to_help", "to_show", "to_cry", "to_move", "to_jump", "to_live", "to_die", "to_happen", "to_lose", "to_hate", "to_include", "to_turn_on", "to_turn_off", "to_continue", "to_change", "to_wash", "to_clean", "to_lead", "to_understand", "to_watch", "to_discover", "to_imagine", "to_introduce", "to_follow", "to_create", "to_grow", "to_spend", "to_win", "to_offer", "to_learn", "to_appear", "to_disappear", "to_build", "to_break", "to_send", "to_fall", "to_cut", "to_achieve", "to_communicate", "to_kill", "to_pass", "to_fly", "to_swim", "to_decide", "to_return", "to_hope", "to_explain", "to_propose", "to_develop", "to_support", "to_dance", "to_draw", "to_book", "to_be_afraid", "to_agree", "to_check_up", "to_delete", "to_choose", "to_catch", "to_ask", "to_answer", "to_hesitate", "air", "wind", "water", "west", "east", "north", "south", "tree", "sea", "ocean", "rock", "plant", "flower", "forest", "person", "night", "morning", "day", "evening", "life", "mountain", "land", "house", "fire", "country", "animal", "bird", "fish", "insect", "city", "world", "boy", "girl", "mother", "father", "son", "daughter", "baby", "family", "grand_mother", "grand_father", "children", "home", "love", "apartment", "joy", "nephew", "aunt", "uncle", "cousin", "man", "woman", "child", "sister", "brother", "relatives", "friend", "wife", "husband", "address", "happiness", "people", "phone", "question", "place", "market", "order", "food", "work", "communication", "story", "relax", "time", "word", "dialogue", "meeting", "week", "distance", "club", "theatre", "cinema", "coffee_shop", "friendship", "behavior", "attitude", "student", "university", "union", "party", "date", "sweetheart", "leisure_time", "road", "ticket", "map", "motel", "highway", "reception", "wallet", "bank", "subway", "cab", "parking", "food_order", "cash", "passport", "permission", "lawyer", "problem", "waiting_room", "transfer", "bag", "suitcase", "property", "law", "police_station", "price", "price_list", "courier", "delivery", "location", "route", "agreement", "hospital", "ambulance", "afraid", "angry", "asleep", "attentive", "available", "basic", "beautiful", "big", "brave", "busy", "calm", "careful", "cheap", "clean", "clever", "cold", "comfortable", "confident", "constant", "curious", "dangerous", "dark", "deep", "different", "difficult", "dirty", "easy", "every", "expensive", "exact", "fast", "fair", "fine", "foreign", "free", "fresh", "full", "funny", "guilty", "healthy", "hard", "helpful", "honest", "hot", "hungry", "important", "illegal", "impossible", "independent", "interesting", "kind", "legal", "little", "lucky", "necessary", "normal", "old", "opposite", "perfect", "poor", "powerful", "possible", "quiet", "rare", "recent", "relevant", "remote", "safe", "short_image", "small", "strange", "successful", "tasty", "terrible", "tired", "warm", "weak", "responsible", "sad", "international", "together", "according", "again", "always", "beautifully", "carefully", "correctly", "especially", "friendly", "indeed", "above", "accidentally", "actually", "badly", "besides", "briefly", "certainly", "daily", "dreamily", "even", "eventually", "foolishly", "forward", "ever", "equally", "fortunately", "honestly", "instead", "inside", "also", "hardly", "lately", "less", "loudly", "nearly", "never", "only", "once", "often", "perhaps", "quickly", "probably", "rarely", "really", "sometimes", "yesterday", "thus", "somehow", "soon", "regularly", "somewhere", "ability", "accident", "action", "actor", "actress", "advertisement", "advice", "airport", "alphabet", "apartment", "appearance", "appointment", "argument", "artist", "assistant", "attention", "audience", "author", "autumn", "background", "balcony", "band", "bath", "bathroom", "battery", "beauty", "behavior", "bicycle", "bill", "biology", "blanket", "blood", "board", "boss", "brain", "branch", "bridge", "breakfast", "building", "bus_stop", "businessman", "businesswoman", "calendar", "camera", "cancer", "candidate", "capital", "carpet", "cartoon", "cash", "castle", "ceiling", "celebrity", "century", "ceremony", "champion", "championship", "channel", "charity", "chemistry", "childhood", "choice", "church", "cigarette", "circle", "climate", "closet", "club", "coach", "colleague", "college", "comedy", "competition", "complaint", "concert", "condition", "conference", "confidence", "connection", "contact", "contest", "continent", "conversation", "costume", "countryside", "cousin", "criminal", "culture", "currency", "customer", "damage", "danger", "database", "decade", "decision", "degree", "department", "design", "dessert", "detail", "diary", "dictionary", "diet", "difficulty", "direction", "disaster", "discovery", "disease", "distance", "document", "drama", "drawing", "dream", "driver", "driving", "economy", "education", "election", "email", "employee", "employer", "energy", "engine", "engineer", "entrance", "environment", "equipment", "error", "event", "evidence", "example", "exchange", "exercise", "exhibition", "exit", "experience", "experiment", "explanation", "factory", "failure", "fan", "farm", "fashion", "fear", "feature", "fence", "fiction", "field", "file", "film", "final_image", "finger", "fire", "flight", "floor", "flour", "focus", "food", "football", "form", "fortune", "frame", "freedom", "function", "furniture", "gallery", "garage", "garden", "gate", "generation", "gift", "goal", "gold", "golf", "government", "grade", "graduate", "graduation", "grammar", "grass", "guest", "guide", "habit", "hair", "hall", "handbag", "headline", "health", "headline", "headline", "heart", "heat", "height", "hero", "history", "holiday", "home", "homework", "honor", "hospital"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

        if (dataBaseHelper.getWordsDataBase(1)[0] == null) {
            dataBaseHelper.setDataBase(WORD_ENG_ARRAY, WORD_TRANSCRIPTION, WORD_UK_ARRAY, NAME_IMAGES);
            finish();
            startActivity(new Intent(this, WordsFast.class));

        } else {
            finish();
            startActivity(new Intent(this, WordsFast.class));
        }

    }
}