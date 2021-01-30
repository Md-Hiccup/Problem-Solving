package hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScrapStackExchange {

    final static String string = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "\n" +
            "    <title>Newest Questions - Page 44 - Electrical Engineering Stack Exchange</title>\n" +
            "    <link rel=\"shortcut icon\" href=\"//cdn.sstatic.net/electronics/img/favicon.ico\">\n" +
            "    <link rel=\"apple-touch-icon image_src\" href=\"//cdn.sstatic.net/electronics/img/apple-touch-icon.png\">\n" +
            "    <link rel=\"search\" type=\"application/opensearchdescription+xml\" title=\"Electrical Engineering Stack Exchange\" href=\"/opensearch.xml\">\n" +
            "\n" +
            "    <script type=\"text/javascript\" src=\"//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\"></script>\n" +
            "    <script type=\"text/javascript\" src=\"//cdn.sstatic.net/js/stub.js?v=5d233283ca8d\"></script>\n" +
            "    <link rel=\"stylesheet\" type=\"text/css\" href=\"//cdn.sstatic.net/electronics/all.css?v=672ddec9ce04\">\n" +
            "\n" +
            "\n" +
            "                <script type=\"text/x-mathjax-config\">\n" +
            "                    MathJax.Hub.Config({\"HTML-CSS\": { preferredFont: \"TeX\", availableFonts: [\"STIX\",\"TeX\"], linebreaks: { automatic:true }, EqnChunk: (MathJax.Hub.Browser.isMobile ? 10 : 50) },\n" +
            "                                        tex2jax: { inlineMath: [ [\"\\\\$\", \"\\\\$\"] ], displayMath: [ [\"$$\",\"$$\"], [\"\\\\[\", \"\\\\]\"] ], processEscapes: true, ignoreClass: \"tex2jax_ignore|dno\" },\n" +
            "                                        TeX: {  noUndefined: { attributes: { mathcolor: \"red\", mathbackground: \"#FFEEEE\", mathsize: \"90%\" } }, Macros: { href: \"{}\" } },\n" +
            "                                        messageStyle: \"none\"\n" +
            "                });\n" +
            "                </script>\n" +
            "                <script type=\"text/javascript\" src=\"http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS_HTML\"></script>\n" +
            "\n" +
            "    <script type=\"text/javascript\">\n" +
            "        StackExchange.ready(function () {\n" +
            "            StackExchange.realtime.init('sockets.ny.stackexchange.com');\n" +
            "            StackExchange.realtime.subscribeToInboxNotifications();\n" +
            "                    StackExchange.realtime.subscribeToReputationNotifications('135');\n" +
            "                });\n" +
            "    </script>\n" +
            "    <script type=\"text/javascript\">\n" +
            "        StackExchange.init({\"stackAuthUrl\":\"https://stackauth.com\",\"serverTime\":1377686850,\"styleCode\":true,\"enableUserHovercards\":true,\"site\":{\"name\":\"Electrical Engineering Stack Exchange\",\"description\":\"Q&A for electronics and electrical engineering professionals, students, and enthusiasts\",\"isNoticesTabEnabled\":true,\"recaptchaPublicKey\":\"6LdsB7sSAAAAAAzjgEF_Hd8vXv-C42sa_KyofaGR\",\"enableSocialMediaInSharePopup\":true},\"user\":{\"fkey\":\"964caaf8350dc8ae69af722ba29b4a1d\",\"isAnonymous\":true}});\n" +
            "        StackExchange.using.setCacheBreakers({\"js/prettify-full.js\":\"6c261bebf56a\",\"js/moderator.js\":\"ed7a8238b2f8\",\"js/full-anon.js\":\"5f9bf5810297\",\"js/full.js\":\"027ac5ea264e\",\"js/wmd.js\":\"cff10cca4fd9\",\"js/third-party/jquery.autocomplete.min.js\":\"e5f01e97f7c3\",\"js/mobile.js\":\"82a79dbb7259\",\"js/help.js\":\"6e6623243cf6\",\"js/tageditor.js\":\"450c9e8426fc\",\"js/tageditornew.js\":\"b6c68ad4c7dd\",\"js/inline-tag-editing.js\":\"8e84e8a137f7\",\"js/revisions.js\":\"d3e781ee5528\",\"js/review.js\":\"947758ba83ea\",\"js/tagsuggestions.js\":\"aa48ef6154df\",\"js/post-validation.js\":\"bb996020492a\",\"js/explore-qlist.js\":\"1c5bbd79b562\",\"js/events.js\":\"27a33f0b2cad\"});\n" +
            "        StackExchange.using.setCacheBreakers({\"js/mathjax-editing.js\":\"6da1b6cfe19f\",\"js/external-editor.js\":\"51c0a8d46d29\"});\n" +
            "    </script>\n" +
            "    <script type=\"text/javascript\">\n" +
            "        StackExchange.using(\"gps\", function() {\n" +
            "             StackExchange.gps.init(true);\n" +
            "        });\n" +
            "    </script>\n" +
            "\n" +
            "        <script type=\"text/javascript\">\n" +
            "            StackExchange.ready(function () {\n" +
            "                $('#nav-tour').click(function () {\n" +
            "                    StackExchange.using(\"gps\", function() {\n" +
            "                        StackExchange.gps.track(\"aboutpage.click\", { aboutclick_location: \"headermain\" }, true);\n" +
            "                    });\n" +
            "                });\n" +
            "            });\n" +
            "        </script>\n" +
            "</head>\n" +
            "<body class=\"questions-page\">\n" +
            "    <noscript><div id=\"noscript-padding\"></div></noscript>\n" +
            "    <div id=\"notify-container\"></div>\n" +
            "    <div id=\"overlay-header\"></div>\n" +
            "    <div id=\"custom-header\"></div>\n" +
            "\n" +
            "    <div class=\"container\">\n" +
            "        <div id=\"header\" class=headeranon>\n" +
            "            <div id=\"portalLink\">\n" +
            "                <a class=\"genu\" href=\"http://stackexchange.com\" onclick=\"StackExchange.ready(function(){genuwine.click();});return false;\">Stack Exchange</a>\n" +
            "            </div>\n" +
            "            <div id=\"topbar\">\n" +
            "                <div id=\"hlinks\">\n" +
            "\n" +
            "<span id=\"hlinks-user\"></span>\n" +
            "<span id=\"hlinks-nav\">                        <a href=\"/users/login?returnurl=%2fquestions%3fpage%3d44%26sort%3dnewest\">sign up</a>\n" +
            "\n" +
            " <span class=\"lsep\">|</span>\n" +
            "                    <a href=\"/users/login?returnurl=%2fquestions%3fpage%3d44%26sort%3dnewest\">log in</a>\n" +
            "\n" +
            " <span class=\"lsep\">|</span>\n" +
            "</span>\n" +
            "<span id=\"hlinks-custom\"></span>\n" +
            "                </div>\n" +
            "                <div id=\"hsearch\">\n" +
            "                    <form id=\"search\" action=\"/search\" method=\"get\" autocomplete=\"off\">\n" +
            "                        <div>\n" +
            "                            <input autocomplete=\"off\" name=\"q\" class=\"textbox\" placeholder=\"search\" tabindex=\"1\" type=\"text\" maxlength=\"240\" size=\"28\" value=\"\">\n" +
            "                        </div>\n" +
            "                    </form>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <br class=\"cbt\">\n" +
            "            <div id=\"hlogo\">\n" +
            "                <a href=\"/\">\n" +
            "                    Electrical Engineering\n" +
            "                </a>\n" +
            "            </div>\n" +
            "            <div id=\"hmenus\">\n" +
            "                <div class=\"nav mainnavs mainnavsanon\">\n" +
            "                    <ul>\n" +
            "                            <li class=\"youarehere\"><a id=\"nav-questions\" href=\"/questions\">Questions</a></li>\n" +
            "                            <li><a id=\"nav-tags\" href=\"/tags\">Tags</a></li>\n" +
            "                            <li><a id=\"nav-tour\" href=\"/about\">Tour</a></li>\n" +
            "                            <li><a id=\"nav-users\" href=\"/users\">Users</a></li>\n" +
            "                    </ul>\n" +
            "                </div>\n" +
            "                <div class=\"nav askquestion\">\n" +
            "                    <ul>\n" +
            "                        <li>\n" +
            "                            <a id=\"nav-askquestion\"  href=\"/questions/ask\">Ask Question</a>\n" +
            "                        </li>\n" +
            "                    </ul>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "        <div id=\"content\">\n" +
            "\n" +
            "<div id=\"mainbar\">\n" +
            "    <div class=\"subheader\">\n" +
            "        <h1 id=\"h-all-questions\">All Questions</h1>\n" +
            "        <div id=\"tabs\">\n" +
            "<a class=\"youarehere\" href=\"/questions?sort=newest\" title=\"the most recently asked questions\">newest</a>\n" +
            "<a href=\"/questions?sort=featured\" title=\"questions with open bounties\"><span class='bounty-indicator-tab'>3</span>featured</a>\n" +
            "<a href=\"/questions?sort=frequent\" title=\"questions with the most links\">frequent</a>\n" +
            "<a href=\"/questions?sort=votes\" title=\"questions with the most votes\">votes</a>\n" +
            "<a href=\"/questions?sort=active\" title=\"questions that have recent activity\">active</a>\n" +
            "<a href=\"/questions?sort=unanswered\" title=\"questions that have no upvoted answers\">unanswered</a>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "    <div id=\"questions\">\n" +
            "\n" +
            "<div class=\"question-summary\" id=\"question-summary-78358\">\n" +
            "    <div class=\"statscontainer\">\n" +
            "        <div class=\"statsarrow\"></div>\n" +
            "        <div class=\"stats\">\n" +
            "            <div class=\"vote\">\n" +
            "                <div class=\"votes\">\n" +
            "                    <span class=\"vote-count-post \"><strong>-1</strong></span>\n" +
            "                    <div class=\"viewcount\">votes</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"status answered\">\n" +
            "                <strong>1</strong>answer\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"views \" title=\"34 views\">\n" +
            "                    34 views\n" +
            "</div>\n" +
            "    </div>\n" +
            "    <div class=\"summary\">\n" +
            "        <h3><a href=\"/questions/78358/controlling-2-kw-230v-infra-red-short-wave-heaters-using-electronic-device\" class=\"question-hyperlink\">controlling 2 kw,230v- infra red short wave heaters using electronic device</a></h3>\n" +
            "        <div class=\"excerpt\">\n" +
            "            i want to control infra red short wave heaters 230v,2kw, with some electronic device,\n" +
            "it is an open loop system,where i want to give analog signal to heater from 0 to 100% .\n" +
            "i cant take Thermocouple ...\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"tags t-voltage-regulator t-solid-state-relay t-dimming\">\n" +
            "            <a href=\"/questions/tagged/voltage-regulator\" class=\"post-tag\" title=\"show questions tagged 'voltage-regulator'\" rel=\"tag\">voltage-regulator</a> <a href=\"/questions/tagged/solid-state-relay\" class=\"post-tag\" title=\"show questions tagged 'solid-state-relay'\" rel=\"tag\">solid-state-relay</a> <a href=\"/questions/tagged/dimming\" class=\"post-tag\" title=\"show questions tagged 'dimming'\" rel=\"tag\">dimming</a>\n" +
            "\n" +
            "        </div>\n" +
            "        <div class=\"started fr\">\n" +
            "\n" +
            "\n" +
            "    <div class=\"user-info \">\n" +
            "        <div class=\"user-action-time\">\n" +
            "\n" +
            "\n" +
            "                    asked <span title=\"2013-08-08 10:06:07Z\" class=\"relativetime\">Aug 8 at 10:06</span>\n" +
            "        </div>\n" +
            "        <div class=\"user-gravatar32\">\n" +
            "            <a href=\"/users/27245/user27245\"><div class=\"\"><img src=\"https://www.gravatar.com/avatar/73e6c66117a190c5cc03a90caf569aae?s=32&d=identicon&r=PG\" alt=\"\" width=\"32\" height=\"32\"></div></a>\n" +
            "        </div>\n" +
            "        <div class=\"user-details\">\n" +
            "            <a href=\"/users/27245/user27245\">user27245</a><br>\n" +
            "            <span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">1</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"question-summary\" id=\"question-summary-78355\">\n" +
            "    <div class=\"statscontainer\">\n" +
            "        <div class=\"statsarrow\"></div>\n" +
            "        <div class=\"stats\">\n" +
            "            <div class=\"vote\">\n" +
            "                <div class=\"votes\">\n" +
            "                    <span class=\"vote-count-post \"><strong>0</strong></span>\n" +
            "                    <div class=\"viewcount\">votes</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"status unanswered\">\n" +
            "                <strong>0</strong>answers\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"views \" title=\"47 views\">\n" +
            "                    47 views\n" +
            "</div>\n" +
            "    </div>\n" +
            "    <div class=\"summary\">\n" +
            "        <h3><a href=\"/questions/78355/how-to-synchronize-internal-rtc-to-computer-time-and-date\" class=\"question-hyperlink\">how to synchronize internal RTC to computer time and date</a></h3>\n" +
            "        <div class=\"excerpt\">\n" +
            "            i am using pic18f67k22 controller.i already configure and initialize internal RTC. But i want start RTC to computer time.so how i can synchronize pic RTC to computer.i have one computer application ...\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"tags t-microcontroller t-pic t-rtc\">\n" +
            "            <a href=\"/questions/tagged/microcontroller\" class=\"post-tag\" title=\"show questions tagged 'microcontroller'\" rel=\"tag\">microcontroller</a> <a href=\"/questions/tagged/pic\" class=\"post-tag\" title=\"show questions tagged 'pic'\" rel=\"tag\">pic</a> <a href=\"/questions/tagged/rtc\" class=\"post-tag\" title=\"show questions tagged 'rtc'\" rel=\"tag\">rtc</a>\n" +
            "\n" +
            "        </div>\n" +
            "        <div class=\"started fr\">\n" +
            "\n" +
            "\n" +
            "    <div class=\"user-info \">\n" +
            "        <div class=\"user-action-time\">\n" +
            "\n" +
            "\n" +
            "                    asked <span title=\"2013-08-08 08:52:58Z\" class=\"relativetime\">Aug 8 at 8:52</span>\n" +
            "        </div>\n" +
            "        <div class=\"user-gravatar32\">\n" +
            "            <a href=\"/users/23841/shail-korat\"><div class=\"\"><img src=\"https://www.gravatar.com/avatar/649adca335821feacbd54299440806f2?s=32&d=identicon&r=PG\" alt=\"\" width=\"32\" height=\"32\"></div></a>\n" +
            "        </div>\n" +
            "        <div class=\"user-details\">\n" +
            "            <a href=\"/users/23841/shail-korat\">shail korat</a><br>\n" +
            "            <span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">23</span><span title=\"6 bronze badges\"><span class=\"badge3\"></span><span class=\"badgecount\">6</span></span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"question-summary\" id=\"question-summary-78353\">\n" +
            "    <div class=\"statscontainer\">\n" +
            "        <div class=\"statsarrow\"></div>\n" +
            "        <div class=\"stats\">\n" +
            "            <div class=\"vote\">\n" +
            "                <div class=\"votes\">\n" +
            "                    <span class=\"vote-count-post \"><strong>1</strong></span>\n" +
            "                    <div class=\"viewcount\">vote</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"status answered-accepted\">\n" +
            "                <strong>1</strong>answer\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"views \" title=\"46 views\">\n" +
            "                    46 views\n" +
            "</div>\n" +
            "    </div>\n" +
            "    <div class=\"summary\">\n" +
            "        <h3><a href=\"/questions/78353/spi-interfacing-using-serial-port-or-usb\" class=\"question-hyperlink\">SPI Interfacing using Serial Port or USB</a></h3>\n" +
            "        <div class=\"excerpt\">\n" +
            "            I have a nRF24L01+ module from Nordic Semiconductors. It has SPI interface. My laptop has USB ports and I have a Serial Port (Using a USB-to-Serial_Port adapter). What is the best possible solution to ...\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"tags t-usb t-serial t-spi t-interface\">\n" +
            "            <a href=\"/questions/tagged/usb\" class=\"post-tag\" title=\"show questions tagged 'usb'\" rel=\"tag\">usb</a> <a href=\"/questions/tagged/serial\" class=\"post-tag\" title=\"show questions tagged 'serial'\" rel=\"tag\">serial</a> <a href=\"/questions/tagged/spi\" class=\"post-tag\" title=\"show questions tagged 'spi'\" rel=\"tag\">spi</a> <a href=\"/questions/tagged/interface\" class=\"post-tag\" title=\"show questions tagged 'interface'\" rel=\"tag\">interface</a>\n" +
            "\n" +
            "        </div>\n" +
            "        <div class=\"started fr\">\n" +
            "\n" +
            "\n" +
            "    <div class=\"user-info \">\n" +
            "        <div class=\"user-action-time\">\n" +
            "\n" +
            "\n" +
            "                    asked <span title=\"2013-08-08 08:32:08Z\" class=\"relativetime\">Aug 8 at 8:32</span>\n" +
            "        </div>\n" +
            "        <div class=\"user-gravatar32\">\n" +
            "            <a href=\"/users/7329/subin-sebastian\"><div class=\"\"><img src=\"https://www.gravatar.com/avatar/b3b512420352799f21d1e7933b59b9ed?s=32&d=identicon&r=PG\" alt=\"\" width=\"32\" height=\"32\"></div></a>\n" +
            "        </div>\n" +
            "        <div class=\"user-details\">\n" +
            "            <a href=\"/users/7329/subin-sebastian\">Subin Sebastian</a><br>\n" +
            "            <span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">211</span><span title=\"1 silver badge\"><span class=\"badge2\"></span><span class=\"badgecount\">1</span></span><span title=\"7 bronze badges\"><span class=\"badge3\"></span><span class=\"badgecount\">7</span></span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"question-summary\" id=\"question-summary-78351\">\n" +
            "    <div class=\"statscontainer\">\n" +
            "        <div class=\"statsarrow\"></div>\n" +
            "        <div class=\"stats\">\n" +
            "            <div class=\"vote\">\n" +
            "                <div class=\"votes\">\n" +
            "                    <span class=\"vote-count-post \"><strong>2</strong></span>\n" +
            "                    <div class=\"viewcount\">votes</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"status answered-accepted\">\n" +
            "                <strong>2</strong>answers\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"views \" title=\"54 views\">\n" +
            "                    54 views\n" +
            "</div>\n" +
            "    </div>\n" +
            "    <div class=\"summary\">\n" +
            "        <h3><a href=\"/questions/78351/trouble-on-understanding-alu-2-bit-design\" class=\"question-hyperlink\">Trouble on understanding ALU 2-bit design</a></h3>\n" +
            "        <div class=\"excerpt\">\n" +
            "            I'm new to this site and I'm pretty \"noobish\" to electrical engineering coming from a software engineering background I was hoping someone could help me understand this design a bit. I've highlighted ...\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"tags t-alu\">\n" +
            "            <a href=\"/questions/tagged/alu\" class=\"post-tag\" title=\"show questions tagged 'alu'\" rel=\"tag\">alu</a>\n" +
            "\n" +
            "        </div>\n" +
            "        <div class=\"started fr\">\n" +
            "\n" +
            "\n" +
            "    <div class=\"user-info \">\n" +
            "        <div class=\"user-action-time\">\n" +
            "\n" +
            "\n" +
            "                    asked <span title=\"2013-08-08 08:20:46Z\" class=\"relativetime\">Aug 8 at 8:20</span>\n" +
            "        </div>\n" +
            "        <div class=\"user-gravatar32\">\n" +
            "            <a href=\"/users/27251/thecodemonsters\"><div class=\"\"><img src=\"https://www.gravatar.com/avatar/b02a007bf995a0986bd3c55d6b5bc3e6?s=32&d=identicon&r=PG\" alt=\"\" width=\"32\" height=\"32\"></div></a>\n" +
            "        </div>\n" +
            "        <div class=\"user-details\">\n" +
            "            <a href=\"/users/27251/thecodemonsters\">theCodeMonsters</a><br>\n" +
            "            <span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">13</span><span title=\"2 bronze badges\"><span class=\"badge3\"></span><span class=\"badgecount\">2</span></span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"question-summary\" id=\"question-summary-78348\">\n" +
            "    <div class=\"statscontainer\">\n" +
            "        <div class=\"statsarrow\"></div>\n" +
            "        <div class=\"stats\">\n" +
            "            <div class=\"vote\">\n" +
            "                <div class=\"votes\">\n" +
            "                    <span class=\"vote-count-post \"><strong>3</strong></span>\n" +
            "                    <div class=\"viewcount\">votes</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"status answered\">\n" +
            "                <strong>1</strong>answer\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"views \" title=\"57 views\">\n" +
            "                    57 views\n" +
            "</div>\n" +
            "    </div>\n" +
            "    <div class=\"summary\">\n" +
            "        <h3><a href=\"/questions/78348/small-max-5x5-mm-connector-panel-mount-for-asyncronous-serial-interface\" class=\"question-hyperlink\">Small (max 5x5 mm) connector, panel mount, for asyncronous serial interface?</a></h3>\n" +
            "        <div class=\"excerpt\">\n" +
            "            I opened a small router and hooked up 2 wires on the PCB (to catch the serial data). That works fine.\n" +
            "\n" +
            "Now I'm looking for a way to make a small (tiny) connector in the enclosure, so for future use i ...\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"tags t-pcb t-connector t-cases t-mount\">\n" +
            "            <a href=\"/questions/tagged/pcb\" class=\"post-tag\" title=\"show questions tagged 'pcb'\" rel=\"tag\">pcb</a> <a href=\"/questions/tagged/connector\" class=\"post-tag\" title=\"show questions tagged 'connector'\" rel=\"tag\">connector</a> <a href=\"/questions/tagged/cases\" class=\"post-tag\" title=\"show questions tagged 'cases'\" rel=\"tag\">cases</a> <a href=\"/questions/tagged/mount\" class=\"post-tag\" title=\"show questions tagged 'mount'\" rel=\"tag\">mount</a>\n" +
            "\n" +
            "        </div>\n" +
            "        <div class=\"started fr\">\n" +
            "\n" +
            "\n" +
            "    <div class=\"user-info \">\n" +
            "        <div class=\"user-action-time\">\n" +
            "\n" +
            "\n" +
            "                    asked <span title=\"2013-08-08 07:20:56Z\" class=\"relativetime\">Aug 8 at 7:20</span>\n" +
            "        </div>\n" +
            "        <div class=\"user-gravatar32\">\n" +
            "            <a href=\"/users/8524/rogier\"><div class=\"\"><img src=\"https://www.gravatar.com/avatar/181219cd20b8036ef8ec45b94aed6474?s=32&d=identicon&r=PG\" alt=\"\" width=\"32\" height=\"32\"></div></a>\n" +
            "        </div>\n" +
            "        <div class=\"user-details\">\n" +
            "            <a href=\"/users/8524/rogier\">Rogier</a><br>\n" +
            "            <span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">165</span><span title=\"6 bronze badges\"><span class=\"badge3\"></span><span class=\"badgecount\">6</span></span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"question-summary\" id=\"question-summary-78345\">\n" +
            "    <div class=\"statscontainer\">\n" +
            "        <div class=\"statsarrow\"></div>\n" +
            "        <div class=\"stats\">\n" +
            "            <div class=\"vote\">\n" +
            "                <div class=\"votes\">\n" +
            "                    <span class=\"vote-count-post \"><strong>4</strong></span>\n" +
            "                    <div class=\"viewcount\">votes</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"status answered-accepted\">\n" +
            "                <strong>1</strong>answer\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"views \" title=\"69 views\">\n" +
            "                    69 views\n" +
            "</div>\n" +
            "    </div>\n" +
            "    <div class=\"summary\">\n" +
            "        <h3><a href=\"/questions/78345/what-happened-to-the-to-3-package\" class=\"question-hyperlink\">What happened to the TO-3 package?</a></h3>\n" +
            "        <div class=\"excerpt\">\n" +
            "            TO-3 used to be a common package for power transistors, but you don't see them much anymore. It can't be just because of SMT, TO-220 is still much in use. TO-3 has a much lower thermal resistance than ...\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"tags t-packages\">\n" +
            "            <a href=\"/questions/tagged/packages\" class=\"post-tag\" title=\"show questions tagged 'packages'\" rel=\"tag\">packages</a>\n" +
            "\n" +
            "        </div>\n" +
            "        <div class=\"started fr\">\n" +
            "\n" +
            "\n" +
            "    <div class=\"user-info \">\n" +
            "        <div class=\"user-action-time\">\n" +
            "\n" +
            "\n" +
            "                    asked <span title=\"2013-08-08 07:05:21Z\" class=\"relativetime\">Aug 8 at 7:05</span>\n" +
            "        </div>\n" +
            "        <div class=\"user-gravatar32\">\n" +
            "            <a href=\"/users/27167/radagast\"><div class=\"\"><img src=\"https://www.gravatar.com/avatar/294b3e797acb485f50878567a54bfec8?s=32&d=identicon&r=PG\" alt=\"\" width=\"32\" height=\"32\"></div></a>\n" +
            "        </div>\n" +
            "        <div class=\"user-details\">\n" +
            "            <a href=\"/users/27167/radagast\">radagast</a><br>\n" +
            "            <span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">334</span><span title=\"1 silver badge\"><span class=\"badge2\"></span><span class=\"badgecount\">1</span></span><span title=\"11 bronze badges\"><span class=\"badge3\"></span><span class=\"badgecount\">11</span></span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"question-summary\" id=\"question-summary-78337\">\n" +
            "    <div class=\"statscontainer\">\n" +
            "        <div class=\"statsarrow\"></div>\n" +
            "        <div class=\"stats\">\n" +
            "            <div class=\"vote\">\n" +
            "                <div class=\"votes\">\n" +
            "                    <span class=\"vote-count-post \"><strong>16</strong></span>\n" +
            "                    <div class=\"viewcount\">votes</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"status answered-accepted\">\n" +
            "                <strong>2</strong>answers\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"views \" title=\"431 views\">\n" +
            "                    431 views\n" +
            "</div>\n" +
            "    </div>\n" +
            "    <div class=\"summary\">\n" +
            "        <h3><a href=\"/questions/78337/which-way-does-electricity-power-a-circuit\" class=\"question-hyperlink\">Which way does electricity power a circuit?</a></h3>\n" +
            "        <div class=\"excerpt\">\n" +
            "            Working with some circuits this summer, I ran into what everyone eventually does: Current flows from + to - despite the electrons flowing (well, bumping into eachother) from - to +. I understand the ...\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"tags t-power-supply t-current t-analog\">\n" +
            "            <a href=\"/questions/tagged/power-supply\" class=\"post-tag\" title=\"show questions tagged 'power-supply'\" rel=\"tag\">power-supply</a> <a href=\"/questions/tagged/current\" class=\"post-tag\" title=\"show questions tagged 'current'\" rel=\"tag\">current</a> <a href=\"/questions/tagged/analog\" class=\"post-tag\" title=\"show questions tagged 'analog'\" rel=\"tag\">analog</a>\n" +
            "\n" +
            "        </div>\n" +
            "        <div class=\"started fr\">\n" +
            "\n" +
            "\n" +
            "    <div class=\"user-info \">\n" +
            "        <div class=\"user-action-time\">\n" +
            "\n" +
            "\n" +
            "                    asked <span title=\"2013-08-08 04:00:29Z\" class=\"relativetime\">Aug 8 at 4:00</span>\n" +
            "        </div>\n" +
            "        <div class=\"user-gravatar32\">\n" +
            "            <a href=\"/users/27243/tom\"><div class=\"\"><img src=\"https://www.gravatar.com/avatar/bfc2bcb561dd6949178afc5306c1fb25?s=32&d=identicon&r=PG\" alt=\"\" width=\"32\" height=\"32\"></div></a>\n" +
            "        </div>\n" +
            "        <div class=\"user-details\">\n" +
            "            <a href=\"/users/27243/tom\">Tom</a><br>\n" +
            "            <span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">81</span><span title=\"4 bronze badges\"><span class=\"badge3\"></span><span class=\"badgecount\">4</span></span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"question-summary\" id=\"question-summary-78336\">\n" +
            "    <div class=\"statscontainer\">\n" +
            "        <div class=\"statsarrow\"></div>\n" +
            "        <div class=\"stats\">\n" +
            "            <div class=\"vote\">\n" +
            "                <div class=\"votes\">\n" +
            "                    <span class=\"vote-count-post \"><strong>1</strong></span>\n" +
            "                    <div class=\"viewcount\">vote</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"status answered\">\n" +
            "                <strong>2</strong>answers\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"views \" title=\"115 views\">\n" +
            "                    115 views\n" +
            "</div>\n" +
            "    </div>\n" +
            "    <div class=\"summary\">\n" +
            "        <h3><a href=\"/questions/78336/using-relay-with-microcontroller\" class=\"question-hyperlink\">Using Relay With Microcontroller</a></h3>\n" +
            "        <div class=\"excerpt\">\n" +
            "            I have created a boost converter which boost 12v to 60v. I want to be able to pulse this voltage under water.  I would like to have only the positive lead (Vout from boost) to come off the boost ...\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"tags t-microcontroller t-relay\">\n" +
            "            <a href=\"/questions/tagged/microcontroller\" class=\"post-tag\" title=\"show questions tagged 'microcontroller'\" rel=\"tag\">microcontroller</a> <a href=\"/questions/tagged/relay\" class=\"post-tag\" title=\"show questions tagged 'relay'\" rel=\"tag\">relay</a>\n" +
            "\n" +
            "        </div>\n" +
            "        <div class=\"started fr\">\n" +
            "\n" +
            "\n" +
            "    <div class=\"user-info \">\n" +
            "        <div class=\"user-action-time\">\n" +
            "\n" +
            "\n" +
            "                    asked <span title=\"2013-08-08 03:56:44Z\" class=\"relativetime\">Aug 8 at 3:56</span>\n" +
            "        </div>\n" +
            "        <div class=\"user-gravatar32\">\n" +
            "            <a href=\"/users/27242/wallace\"><div class=\"\"><img src=\"https://www.gravatar.com/avatar/ea5a17f0b7d6efa25f118ade0a0db9d5?s=32&d=identicon&r=PG\" alt=\"\" width=\"32\" height=\"32\"></div></a>\n" +
            "        </div>\n" +
            "        <div class=\"user-details\">\n" +
            "            <a href=\"/users/27242/wallace\">Wallace</a><br>\n" +
            "            <span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">58</span><span title=\"7 bronze badges\"><span class=\"badge3\"></span><span class=\"badgecount\">7</span></span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"question-summary\" id=\"question-summary-78329\">\n" +
            "    <div class=\"statscontainer\">\n" +
            "        <div class=\"statsarrow\"></div>\n" +
            "        <div class=\"stats\">\n" +
            "            <div class=\"vote\">\n" +
            "                <div class=\"votes\">\n" +
            "                    <span class=\"vote-count-post \"><strong>0</strong></span>\n" +
            "                    <div class=\"viewcount\">votes</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"status answered\">\n" +
            "                <strong>2</strong>answers\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"views \" title=\"48 views\">\n" +
            "                    48 views\n" +
            "</div>\n" +
            "    </div>\n" +
            "    <div class=\"summary\">\n" +
            "        <h3><a href=\"/questions/78329/how-to-measure-the-current-from-ac-dc-supplier\" class=\"question-hyperlink\">how to measure the current from AC-DC supplier?</a></h3>\n" +
            "        <div class=\"excerpt\">\n" +
            "            I started to learn the AC/DC circuit some times ago. I don't have much experience. But from this semester on, I have some chances to practice it in lab by working on some project. I got a AC/DC power ...\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"tags t-power-supply t-dc\">\n" +
            "            <a href=\"/questions/tagged/power-supply\" class=\"post-tag\" title=\"show questions tagged 'power-supply'\" rel=\"tag\">power-supply</a> <a href=\"/questions/tagged/dc\" class=\"post-tag\" title=\"show questions tagged 'dc'\" rel=\"tag\">dc</a>\n" +
            "\n" +
            "        </div>\n" +
            "        <div class=\"started fr\">\n" +
            "\n" +
            "\n" +
            "    <div class=\"user-info \">\n" +
            "        <div class=\"user-action-time\">\n" +
            "\n" +
            "\n" +
            "                    asked <span title=\"2013-08-08 02:05:53Z\" class=\"relativetime\">Aug 8 at 2:05</span>\n" +
            "        </div>\n" +
            "        <div class=\"user-gravatar32\">\n" +
            "            <a href=\"/users/17060/user1285419\"><div class=\"\"><img src=\"https://www.gravatar.com/avatar/08ee68b20a4eceff26f7eee99b708c08?s=32&d=identicon&r=PG\" alt=\"\" width=\"32\" height=\"32\"></div></a>\n" +
            "        </div>\n" +
            "        <div class=\"user-details\">\n" +
            "            <a href=\"/users/17060/user1285419\">user1285419</a><br>\n" +
            "            <span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">165</span><span title=\"5 bronze badges\"><span class=\"badge3\"></span><span class=\"badgecount\">5</span></span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"question-summary\" id=\"question-summary-78328\">\n" +
            "    <div class=\"statscontainer\">\n" +
            "        <div class=\"statsarrow\"></div>\n" +
            "        <div class=\"stats\">\n" +
            "            <div class=\"vote\">\n" +
            "                <div class=\"votes\">\n" +
            "                    <span class=\"vote-count-post \"><strong>0</strong></span>\n" +
            "                    <div class=\"viewcount\">votes</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"status answered\">\n" +
            "                <strong>1</strong>answer\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"views \" title=\"86 views\">\n" +
            "                    86 views\n" +
            "</div>\n" +
            "    </div>\n" +
            "    <div class=\"summary\">\n" +
            "        <h3><a href=\"/questions/78328/reducing-capacitance-of-a-wire\" class=\"question-hyperlink\">Reducing capacitance of a wire</a></h3>\n" +
            "        <div class=\"excerpt\">\n" +
            "            Given a wire and a piece of foil wired to a bread board, is it possible using capacitors wired in series (or some other method) to significantly reduce the capacitance of the wire/foil?\n" +
            "\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"tags t-capacitor t-capacitance\">\n" +
            "            <a href=\"/questions/tagged/capacitor\" class=\"post-tag\" title=\"show questions tagged 'capacitor'\" rel=\"tag\">capacitor</a> <a href=\"/questions/tagged/capacitance\" class=\"post-tag\" title=\"show questions tagged 'capacitance'\" rel=\"tag\">capacitance</a>\n" +
            "\n" +
            "        </div>\n" +
            "        <div class=\"started fr\">\n" +
            "\n" +
            "\n" +
            "    <div class=\"user-info \">\n" +
            "        <div class=\"user-action-time\">\n" +
            "\n" +
            "\n" +
            "                    asked <span title=\"2013-08-08 02:03:19Z\" class=\"relativetime\">Aug 8 at 2:03</span>\n" +
            "        </div>\n" +
            "        <div class=\"user-gravatar32\">\n" +
            "            <a href=\"/users/27085/j03m\"><div class=\"\"><img src=\"https://www.gravatar.com/avatar/a16354f806a5e7cdf68128173ec06ec6?s=32&d=identicon&r=PG\" alt=\"\" width=\"32\" height=\"32\"></div></a>\n" +
            "        </div>\n" +
            "        <div class=\"user-details\">\n" +
            "            <a href=\"/users/27085/j03m\">j03m</a><br>\n" +
            "            <span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">146</span><span title=\"4 bronze badges\"><span class=\"badge3\"></span><span class=\"badgecount\">4</span></span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"question-summary\" id=\"question-summary-78322\">\n" +
            "    <div class=\"statscontainer\">\n" +
            "        <div class=\"statsarrow\"></div>\n" +
            "        <div class=\"stats\">\n" +
            "            <div class=\"vote\">\n" +
            "                <div class=\"votes\">\n" +
            "                    <span class=\"vote-count-post \"><strong>-2</strong></span>\n" +
            "                    <div class=\"viewcount\">votes</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"status answered-accepted\">\n" +
            "                <strong>1</strong>answer\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"views \" title=\"63 views\">\n" +
            "                    63 views\n" +
            "</div>\n" +
            "    </div>\n" +
            "    <div class=\"summary\">\n" +
            "        <h3><a href=\"/questions/78322/ground-wire-installation\" class=\"question-hyperlink\">Ground Wire Installation [closed]</a></h3>\n" +
            "        <div class=\"excerpt\">\n" +
            "            Currently I do not have ground in my house wiring. I am planing to install ground wiring but the floor around the main service panel is cemented and I don't think I can place a ground rod in the ...\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"tags t-wiring\">\n" +
            "            <a href=\"/questions/tagged/wiring\" class=\"post-tag\" title=\"show questions tagged 'wiring'\" rel=\"tag\">wiring</a>\n" +
            "\n" +
            "        </div>\n" +
            "        <div class=\"started fr\">\n" +
            "\n" +
            "\n" +
            "    <div class=\"user-info \">\n" +
            "        <div class=\"user-action-time\">\n" +
            "\n" +
            "\n" +
            "                    asked <span title=\"2013-08-08 00:38:13Z\" class=\"relativetime\">Aug 8 at 0:38</span>\n" +
            "        </div>\n" +
            "        <div class=\"user-gravatar32\">\n" +
            "            <a href=\"/users/27238/khiz\"><div class=\"\"><img src=\"https://www.gravatar.com/avatar/5a94e8f9238c314cab95243f99332222?s=32&d=identicon&r=PG\" alt=\"\" width=\"32\" height=\"32\"></div></a>\n" +
            "        </div>\n" +
            "        <div class=\"user-details\">\n" +
            "            <a href=\"/users/27238/khiz\">khiz</a><br>\n" +
            "            <span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">33</span><span title=\"3 bronze badges\"><span class=\"badge3\"></span><span class=\"badgecount\">3</span></span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"question-summary\" id=\"question-summary-78319\">\n" +
            "    <div class=\"statscontainer\">\n" +
            "        <div class=\"statsarrow\"></div>\n" +
            "        <div class=\"stats\">\n" +
            "            <div class=\"vote\">\n" +
            "                <div class=\"votes\">\n" +
            "                    <span class=\"vote-count-post \"><strong>1</strong></span>\n" +
            "                    <div class=\"viewcount\">vote</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"status answered\">\n" +
            "                <strong>2</strong>answers\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"views \" title=\"63 views\">\n" +
            "                    63 views\n" +
            "</div>\n" +
            "    </div>\n" +
            "    <div class=\"summary\">\n" +
            "        <h3><a href=\"/questions/78319/performance-of-solar-panel-vs-dc-power-supply\" class=\"question-hyperlink\">Performance of solar panel vs. DC power supply</a></h3>\n" +
            "        <div class=\"excerpt\">\n" +
            "            I am building a solar swamp cooler for burning man (hot dry desert environment).\n" +
            "\n" +
            "Purchased a 15w solar panel that outputs 0.9a at 20V in full sun (verified as true with my voltmeter). The solar panel ...\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"tags t-power-supply t-dc t-solar-cell\">\n" +
            "            <a href=\"/questions/tagged/power-supply\" class=\"post-tag\" title=\"show questions tagged 'power-supply'\" rel=\"tag\">power-supply</a> <a href=\"/questions/tagged/dc\" class=\"post-tag\" title=\"show questions tagged 'dc'\" rel=\"tag\">dc</a> <a href=\"/questions/tagged/solar-cell\" class=\"post-tag\" title=\"show questions tagged 'solar-cell'\" rel=\"tag\">solar-cell</a>\n" +
            "\n" +
            "        </div>\n" +
            "        <div class=\"started fr\">\n" +
            "\n" +
            "\n" +
            "    <div class=\"user-info \">\n" +
            "        <div class=\"user-action-time\">\n" +
            "\n" +
            "\n" +
            "                    asked <span title=\"2013-08-08 00:07:34Z\" class=\"relativetime\">Aug 8 at 0:07</span>\n" +
            "        </div>\n" +
            "        <div class=\"user-gravatar32\">\n" +
            "            <a href=\"/users/27183/nimble\"><div class=\"\"><img src=\"https://www.gravatar.com/avatar/2bb088aedd0b5458b587e3bc104f1edc?s=32&d=identicon&r=PG\" alt=\"\" width=\"32\" height=\"32\"></div></a>\n" +
            "        </div>\n" +
            "        <div class=\"user-details\">\n" +
            "            <a href=\"/users/27183/nimble\">nimble</a><br>\n" +
            "            <span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">11</span><span title=\"1 bronze badge\"><span class=\"badge3\"></span><span class=\"badgecount\">1</span></span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"question-summary\" id=\"question-summary-78318\">\n" +
            "    <div class=\"statscontainer\">\n" +
            "        <div class=\"statsarrow\"></div>\n" +
            "        <div class=\"stats\">\n" +
            "            <div class=\"vote\">\n" +
            "                <div class=\"votes\">\n" +
            "                    <span class=\"vote-count-post \"><strong>0</strong></span>\n" +
            "                    <div class=\"viewcount\">votes</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"status unanswered\">\n" +
            "                <strong>0</strong>answers\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"views \" title=\"23 views\">\n" +
            "                    23 views\n" +
            "</div>\n" +
            "    </div>\n" +
            "    <div class=\"summary\">\n" +
            "        <h3><a href=\"/questions/78318/altium-simulation-node-voltages\" class=\"question-hyperlink\">Altium Simulation Node Voltages</a></h3>\n" +
            "        <div class=\"excerpt\">\n" +
            "            When simulating a circuit in Altium it generates signals based on the components and net labels placed in the circuit, eg:\n" +
            "\n" +
            "<span class='tex2jax_ignore'>r1[i]\n" +
            "r1[p]\n" +
            "v1\n" +
            "v2\n" +
            "</span>\n" +
            "\n" +
            "Altium also adds the ...\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"tags t-simulation t-circuit-analysis t-altium\">\n" +
            "            <a href=\"/questions/tagged/simulation\" class=\"post-tag\" title=\"show questions tagged 'simulation'\" rel=\"tag\">simulation</a> <a href=\"/questions/tagged/circuit-analysis\" class=\"post-tag\" title=\"show questions tagged 'circuit-analysis'\" rel=\"tag\">circuit-analysis</a> <a href=\"/questions/tagged/altium\" class=\"post-tag\" title=\"show questions tagged 'altium'\" rel=\"tag\">altium</a>\n" +
            "\n" +
            "        </div>\n" +
            "        <div class=\"started fr\">\n" +
            "\n" +
            "\n" +
            "    <div class=\"user-info \">\n" +
            "        <div class=\"user-action-time\">\n" +
            "\n" +
            "\n" +
            "                    asked <span title=\"2013-08-07 23:55:41Z\" class=\"relativetime\">Aug 7 at 23:55</span>\n" +
            "        </div>\n" +
            "        <div class=\"user-gravatar32\">\n" +
            "            <a href=\"/users/27237/troy\"><div class=\"\"><img src=\"https://www.gravatar.com/avatar/5c9a9c526c1c796a536814e3b04405d1?s=32&d=identicon&r=PG\" alt=\"\" width=\"32\" height=\"32\"></div></a>\n" +
            "        </div>\n" +
            "        <div class=\"user-details\">\n" +
            "            <a href=\"/users/27237/troy\">Troy</a><br>\n" +
            "            <span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">1</span><span title=\"1 bronze badge\"><span class=\"badge3\"></span><span class=\"badgecount\">1</span></span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"question-summary\" id=\"question-summary-78315\">\n" +
            "    <div class=\"statscontainer\">\n" +
            "        <div class=\"statsarrow\"></div>\n" +
            "        <div class=\"stats\">\n" +
            "            <div class=\"vote\">\n" +
            "                <div class=\"votes\">\n" +
            "                    <span class=\"vote-count-post \"><strong>1</strong></span>\n" +
            "                    <div class=\"viewcount\">vote</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"status answered-accepted\">\n" +
            "                <strong>2</strong>answers\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"views \" title=\"146 views\">\n" +
            "                    146 views\n" +
            "</div>\n" +
            "    </div>\n" +
            "    <div class=\"summary\">\n" +
            "        <h3><a href=\"/questions/78315/why-does-the-voltage-changes-in-this-simple-circuit\" class=\"question-hyperlink\">Why does the voltage changes in this simple circuit?</a></h3>\n" +
            "        <div class=\"excerpt\">\n" +
            "            I'm beginning to learn electronics, and there's something I just can't grasp. I was told that a high resistance in a circuit would lead to a smaller current passing through it, but the voltage would ...\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"tags t-power t-voltage t-current t-resistance t-ohms-law\">\n" +
            "            <a href=\"/questions/tagged/power\" class=\"post-tag\" title=\"show questions tagged 'power'\" rel=\"tag\">power</a> <a href=\"/questions/tagged/voltage\" class=\"post-tag\" title=\"show questions tagged 'voltage'\" rel=\"tag\">voltage</a> <a href=\"/questions/tagged/current\" class=\"post-tag\" title=\"show questions tagged 'current'\" rel=\"tag\">current</a> <a href=\"/questions/tagged/resistance\" class=\"post-tag\" title=\"show questions tagged 'resistance'\" rel=\"tag\">resistance</a> <a href=\"/questions/tagged/ohms-law\" class=\"post-tag\" title=\"show questions tagged 'ohms-law'\" rel=\"tag\">ohms-law</a>\n" +
            "\n" +
            "        </div>\n" +
            "        <div class=\"started fr\">\n" +
            "\n" +
            "\n" +
            "    <div class=\"user-info \">\n" +
            "        <div class=\"user-action-time\">\n" +
            "\n" +
            "\n" +
            "                    asked <span title=\"2013-08-07 23:08:48Z\" class=\"relativetime\">Aug 7 at 23:08</span>\n" +
            "        </div>\n" +
            "        <div class=\"user-gravatar32\">\n" +
            "            <a href=\"/users/27236/wingleader\"><div class=\"\"><img src=\"https://www.gravatar.com/avatar/01d2f745e0e93e81d23ca4214668eadb?s=32&d=identicon&r=PG\" alt=\"\" width=\"32\" height=\"32\"></div></a>\n" +
            "        </div>\n" +
            "        <div class=\"user-details\">\n" +
            "            <a href=\"/users/27236/wingleader\">wingleader</a><br>\n" +
            "            <span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">8</span><span title=\"2 bronze badges\"><span class=\"badge3\"></span><span class=\"badgecount\">2</span></span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"question-summary\" id=\"question-summary-78307\">\n" +
            "    <div class=\"statscontainer\">\n" +
            "        <div class=\"statsarrow\"></div>\n" +
            "        <div class=\"stats\">\n" +
            "            <div class=\"vote\">\n" +
            "                <div class=\"votes\">\n" +
            "                    <span class=\"vote-count-post \"><strong>-1</strong></span>\n" +
            "                    <div class=\"viewcount\">votes</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"status answered-accepted\">\n" +
            "                <strong>4</strong>answers\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div class=\"views \" title=\"89 views\">\n" +
            "                    89 views\n" +
            "</div>\n" +
            "    </div>\n" +
            "    <div class=\"summary\">\n" +
            "        <h3><a href=\"/questions/78307/how-do-i-figure-out-the-correct-polarity-of-a-dc-barrel-connector\" class=\"question-hyperlink\">How do I figure out the correct polarity of a DC barrel connector</a></h3>\n" +
            "        <div class=\"excerpt\">\n" +
            "            I'm in the U.S. and I bought a digital wall clock from the U.K. which came with an AC adapter with input 230V/50Hz/90mA and output 9V/800mA. Now I could get a transformer to convert 120V to 230V but ...\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"tags t-multimeter t-polarity\">\n" +
            "            <a href=\"/questions/tagged/multimeter\" class=\"post-tag\" title=\"show questions tagged 'multimeter'\" rel=\"tag\">multimeter</a> <a href=\"/questions/tagged/polarity\" class=\"post-tag\" title=\"show questions tagged 'polarity'\" rel=\"tag\">polarity</a>\n" +
            "\n" +
            "        </div>\n" +
            "        <div class=\"started fr\">\n" +
            "\n" +
            "\n" +
            "    <div class=\"user-info \">\n" +
            "        <div class=\"user-action-time\">\n" +
            "\n" +
            "\n" +
            "                    asked <span title=\"2013-08-07 21:38:15Z\" class=\"relativetime\">Aug 7 at 21:38</span>\n" +
            "        </div>\n" +
            "        <div class=\"user-gravatar32\">\n" +
            "            <a href=\"/users/27233/eydelber\"><div class=\"\"><img src=\"https://www.gravatar.com/avatar/f882365e2a203587fe941634b3a376b2?s=32&d=identicon&r=PG\" alt=\"\" width=\"32\" height=\"32\"></div></a>\n" +
            "        </div>\n" +
            "        <div class=\"user-details\">\n" +
            "            <a href=\"/users/27233/eydelber\">eydelber</a><br>\n" +
            "            <span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">101</span><span title=\"4 bronze badges\"><span class=\"badge3\"></span><span class=\"badgecount\">4</span></span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "        </div>\n" +
            "\n" +
            "    <br class=\"cbt\">\n" +
            "\n" +
            "\n" +
            "    <div class=\"page-sizer fr\">\n" +
            "            <a href=\"/questions?pagesize=15&amp;sort=newest\" title=\"show 15 items per page\" class=\"page-numbers current\">15</a>\n" +
            "            <a href=\"/questions?pagesize=30&amp;sort=newest\" title=\"show 30 items per page\" class=\"page-numbers \">30</a>\n" +
            "            <a href=\"/questions?pagesize=50&amp;sort=newest\" title=\"show 50 items per page\" class=\"page-numbers \">50</a>\n" +
            "        <span class=\"page-numbers desc\">per page</span>\n" +
            "    </div>\n" +
            "<div class=\"pager fl\" >\n" +
            "<a href=\"/questions?page=43&amp;sort=newest\" title=\"go to page 43\" rel=\"prev\"><span class=\"page-numbers prev\">prev </span></a>\n" +
            "<a href=\"/questions?page=1&amp;sort=newest\" title=\"go to page 1\"><span class=\"page-numbers\">1</span></a>\n" +
            "<span class=\"page-numbers dots\">&hellip;</span>\n" +
            "<a href=\"/questions?page=42&amp;sort=newest\" title=\"go to page 42\"><span class=\"page-numbers\">42</span></a>\n" +
            "<a href=\"/questions?page=43&amp;sort=newest\" title=\"go to page 43\"><span class=\"page-numbers\">43</span></a>\n" +
            "<span class=\"page-numbers current\">44</span>\n" +
            "<a href=\"/questions?page=45&amp;sort=newest\" title=\"go to page 45\"><span class=\"page-numbers\">45</span></a>\n" +
            "<a href=\"/questions?page=46&amp;sort=newest\" title=\"go to page 46\"><span class=\"page-numbers\">46</span></a>\n" +
            "<span class=\"page-numbers dots\">&hellip;</span>\n" +
            "<a href=\"/questions?page=1340&amp;sort=newest\" title=\"go to page 1340\"><span class=\"page-numbers\">1340</span></a>\n" +
            "<a href=\"/questions?page=45&amp;sort=newest\" title=\"go to page 45\" rel=\"next\"><span class=\"page-numbers next\"> next</span></a>\n" +
            "</div>\n" +
            "\n" +
            "</div>\n" +
            "<div id=\"sidebar\">\n" +
            "    <div class=\"module\" id=\"questions-count\">\n" +
            "        <div class=\"summarycount al\">20,098</div>\n" +
            "        <p>questions</p>\n" +
            "    </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "    <div class=\"module\" id=\"related-tags\">\n" +
            "    <h4 id=\"h-related-tags\">Related Tags</h4>\n" +
            "\n" +
            "            <a href=\"/questions/tagged/arduino\" class=\"post-tag\" title=\"show questions tagged 'arduino'\" rel=\"tag\">arduino</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">2030</span></span><br>\n" +
            "            <a href=\"/questions/tagged/microcontroller\" class=\"post-tag\" title=\"show questions tagged 'microcontroller'\" rel=\"tag\">microcontroller</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">1432</span></span><br>\n" +
            "            <a href=\"/questions/tagged/power-supply\" class=\"post-tag\" title=\"show questions tagged 'power-supply'\" rel=\"tag\">power-supply</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">899</span></span><br>\n" +
            "            <a href=\"/questions/tagged/led\" class=\"post-tag\" title=\"show questions tagged 'led'\" rel=\"tag\">led</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">789</span></span><br>\n" +
            "            <a href=\"/questions/tagged/pic\" class=\"post-tag\" title=\"show questions tagged 'pic'\" rel=\"tag\">pic</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">735</span></span><br>\n" +
            "            <a href=\"/questions/tagged/power\" class=\"post-tag\" title=\"show questions tagged 'power'\" rel=\"tag\">power</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">730</span></span><br>\n" +
            "            <a href=\"/questions/tagged/voltage\" class=\"post-tag\" title=\"show questions tagged 'voltage'\" rel=\"tag\">voltage</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">608</span></span><br>\n" +
            "            <a href=\"/questions/tagged/batteries\" class=\"post-tag\" title=\"show questions tagged 'batteries'\" rel=\"tag\">batteries</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">593</span></span><br>\n" +
            "            <a href=\"/questions/tagged/transistors\" class=\"post-tag\" title=\"show questions tagged 'transistors'\" rel=\"tag\">transistors</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">577</span></span><br>\n" +
            "            <a href=\"/questions/tagged/pcb\" class=\"post-tag\" title=\"show questions tagged 'pcb'\" rel=\"tag\">pcb</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">570</span></span><br>\n" +
            "            <a href=\"/questions/tagged/capacitor\" class=\"post-tag\" title=\"show questions tagged 'capacitor'\" rel=\"tag\">capacitor</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">564</span></span><br>\n" +
            "            <a href=\"/questions/tagged/usb\" class=\"post-tag\" title=\"show questions tagged 'usb'\" rel=\"tag\">usb</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">538</span></span><br>\n" +
            "            <a href=\"/questions/tagged/digital-logic\" class=\"post-tag\" title=\"show questions tagged 'digital-logic'\" rel=\"tag\">digital-logic</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">522</span></span><br>\n" +
            "            <a href=\"/questions/tagged/sensor\" class=\"post-tag\" title=\"show questions tagged 'sensor'\" rel=\"tag\">sensor</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">500</span></span><br>\n" +
            "            <a href=\"/questions/tagged/avr\" class=\"post-tag\" title=\"show questions tagged 'avr'\" rel=\"tag\">avr</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">493</span></span><br>\n" +
            "            <a href=\"/questions/tagged/op-amp\" class=\"post-tag\" title=\"show questions tagged 'op-amp'\" rel=\"tag\">op-amp</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">447</span></span><br>\n" +
            "            <a href=\"/questions/tagged/current\" class=\"post-tag\" title=\"show questions tagged 'current'\" rel=\"tag\">current</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">436</span></span><br>\n" +
            "            <a href=\"/questions/tagged/fpga\" class=\"post-tag\" title=\"show questions tagged 'fpga'\" rel=\"tag\">fpga</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">431</span></span><br>\n" +
            "            <a href=\"/questions/tagged/circuit\" class=\"post-tag\" title=\"show questions tagged 'circuit'\" rel=\"tag\">circuit</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">423</span></span><br>\n" +
            "            <a href=\"/questions/tagged/resistors\" class=\"post-tag\" title=\"show questions tagged 'resistors'\" rel=\"tag\">resistors</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">394</span></span><br>\n" +
            "            <a href=\"/questions/tagged/audio\" class=\"post-tag\" title=\"show questions tagged 'audio'\" rel=\"tag\">audio</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">394</span></span><br>\n" +
            "            <a href=\"/questions/tagged/motor\" class=\"post-tag\" title=\"show questions tagged 'motor'\" rel=\"tag\">motor</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">384</span></span><br>\n" +
            "            <a href=\"/questions/tagged/voltage-regulator\" class=\"post-tag\" title=\"show questions tagged 'voltage-regulator'\" rel=\"tag\">voltage-regulator</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">377</span></span><br>\n" +
            "            <a href=\"/questions/tagged/mosfet\" class=\"post-tag\" title=\"show questions tagged 'mosfet'\" rel=\"tag\">mosfet</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">374</span></span><br>\n" +
            "            <a href=\"/questions/tagged/switches\" class=\"post-tag\" title=\"show questions tagged 'switches'\" rel=\"tag\">switches</a>&nbsp;<span class=\"item-multiplier\"><span class=\"item-multiplier-x\">&times;</span>&nbsp;<span class=\"item-multiplier-count\">344</span></span><br>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div id=\"footer\" class=\"categories\">\n" +
            "        <div class=\"footerwrap\">\n" +
            "            <div id=\"footer-menu\">\n" +
            "                <div class=\"top-footer-links\">\n" +
            "                        <a href=\"/about\">about</a>\n" +
            "                    <a href=\"/help\">help</a>\n" +
            "                        <a href=\"/help/badges\">badges</a>\n" +
            "                    <a href=\"http://blog.stackexchange.com?blb=1\">blog</a>\n" +
            "                        <a href=\"http://chat.stackexchange.com\">chat</a>\n" +
            "                    <a href=\"http://data.stackexchange.com\">data</a>\n" +
            "                    <a href=\"http://stackexchange.com/legal\">legal</a>\n" +
            "                    <a href=\"http://stackexchange.com/legal/privacy-policy\">privacy policy</a>\n" +
            "                    <a href=\"http://stackexchange.com/about/hiring\">jobs</a>\n" +
            "                    <a href=\"http://stackexchange.com/about/contact\">advertising info</a>\n" +
            "\n" +
            "                    <a onclick='StackExchange.switchMobile(\"on\", \"/questions?page=44&amp;sort=newest\")'>mobile</a>\n" +
            "                    <b><a href=\"/contact\">contact us</a></b>\n" +
            "                        <b><a href=\"http://meta.electronics.stackexchange.com\">feedback</a></b>\n" +
            "\n" +
            "                </div>\n" +
            "                <div id=\"footer-sites\">\n" +
            "                    <table>\n" +
            "    <tr>\n" +
            "            <th colspan=3>\n" +
            "                Technology\n" +
            "            </th>\n" +
            "            <th >\n" +
            "                Life / Arts\n" +
            "            </th>\n" +
            "            <th >\n" +
            "                Culture / Recreation\n" +
            "            </th>\n" +
            "            <th >\n" +
            "                Science\n" +
            "            </th>\n" +
            "            <th >\n" +
            "                Other\n" +
            "            </th>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "            <td>\n" +
            "                <ol>\n" +
            "                        <li><a href=\"http://stackoverflow.com\" title=\"professional and enthusiast programmers\">Stack Overflow</a></li>\n" +
            "                        <li><a href=\"http://serverfault.com\" title=\"professional system and network administrators\">Server Fault</a></li>\n" +
            "                        <li><a href=\"http://superuser.com\" title=\"computer enthusiasts and power users\">Super User</a></li>\n" +
            "                        <li><a href=\"http://webapps.stackexchange.com\" title=\"power users of web applications\">Web Applications</a></li>\n" +
            "                        <li><a href=\"http://askubuntu.com\" title=\"Ubuntu users and developers\">Ask Ubuntu</a></li>\n" +
            "                        <li><a href=\"http://webmasters.stackexchange.com\" title=\"pro webmasters\">Webmasters</a></li>\n" +
            "                        <li><a href=\"http://gamedev.stackexchange.com\" title=\"professional and independent game developers\">Game Development</a></li>\n" +
            "                        <li><a href=\"http://tex.stackexchange.com\" title=\"users of TeX, LaTeX, ConTeXt, and related typesetting systems\">TeX - LaTeX</a></li>\n" +
            "                            </ol></td><td><ol>\n" +
            "                        <li><a href=\"http://programmers.stackexchange.com\" title=\"professional programmers interested in conceptual questions about software development\">Programmers</a></li>\n" +
            "                        <li><a href=\"http://unix.stackexchange.com\" title=\"users of Linux, FreeBSD and other Un*x-like operating systems.\">Unix &amp; Linux</a></li>\n" +
            "                        <li><a href=\"http://apple.stackexchange.com\" title=\"power users of Apple hardware and software\">Ask Different (Apple)</a></li>\n" +
            "                        <li><a href=\"http://wordpress.stackexchange.com\" title=\"WordPress developers and administrators\">WordPress Answers</a></li>\n" +
            "                        <li><a href=\"http://gis.stackexchange.com\" title=\"cartographers, geographers and GIS professionals\">Geographic Information Systems</a></li>\n" +
            "                        <li><a href=\"http://electronics.stackexchange.com\" title=\"electronics and electrical engineering professionals, students, and enthusiasts\">Electrical Engineering</a></li>\n" +
            "                        <li><a href=\"http://android.stackexchange.com\" title=\"enthusiasts and power users of the Android operating system\">Android Enthusiasts</a></li>\n" +
            "                        <li><a href=\"http://security.stackexchange.com\" title=\"IT security professionals\">IT Security</a></li>\n" +
            "                            </ol></td><td><ol>\n" +
            "                        <li><a href=\"http://dba.stackexchange.com\" title=\"database professionals who wish to improve their database skills and learn from others in the community\">Database Administrators</a></li>\n" +
            "                        <li><a href=\"http://drupal.stackexchange.com\" title=\"Drupal developers and administrators\">Drupal Answers</a></li>\n" +
            "                        <li><a href=\"http://sharepoint.stackexchange.com\" title=\"SharePoint enthusiasts\">SharePoint</a></li>\n" +
            "                        <li><a href=\"http://ux.stackexchange.com\" title=\"user experience researchers and experts\">User Experience</a></li>\n" +
            "                        <li><a href=\"http://mathematica.stackexchange.com\" title=\"users of Mathematica\">Mathematica</a></li>\n" +
            "\n" +
            "                        <li>\n" +
            "                            <a href=\"http://stackexchange.com/sites#technology\" class=\"more\">\n" +
            "                                more (13)\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                </ol>\n" +
            "            </td>\n" +
            "            <td>\n" +
            "                <ol>\n" +
            "                        <li><a href=\"http://photo.stackexchange.com\" title=\"professional, enthusiast and amateur photographers\">Photography</a></li>\n" +
            "                        <li><a href=\"http://scifi.stackexchange.com\" title=\"science fiction and fantasy enthusiasts\">Science Fiction &amp; Fantasy</a></li>\n" +
            "                        <li><a href=\"http://cooking.stackexchange.com\" title=\"professional and amateur chefs\">Seasoned Advice (cooking)</a></li>\n" +
            "                        <li><a href=\"http://diy.stackexchange.com\" title=\"contractors and serious DIYers\">Home Improvement</a></li>\n" +
            "\n" +
            "                        <li>\n" +
            "                            <a href=\"http://stackexchange.com/sites#lifearts\" class=\"more\">\n" +
            "                                more (13)\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                </ol>\n" +
            "            </td>\n" +
            "            <td>\n" +
            "                <ol>\n" +
            "                        <li><a href=\"http://english.stackexchange.com\" title=\"linguists, etymologists, and serious English language enthusiasts\">English Language &amp; Usage</a></li>\n" +
            "                        <li><a href=\"http://skeptics.stackexchange.com\" title=\"scientific skepticism\">Skeptics</a></li>\n" +
            "                        <li><a href=\"http://judaism.stackexchange.com\" title=\"those who base their lives on Jewish law and tradition and anyone interested in learning more\">Mi Yodeya (Judaism)</a></li>\n" +
            "                        <li><a href=\"http://travel.stackexchange.com\" title=\"road warriors and seasoned travelers\">Travel</a></li>\n" +
            "                        <li><a href=\"http://christianity.stackexchange.com\" title=\"committed Christians, experts in Christianity and those interested in learning more\">Christianity</a></li>\n" +
            "                        <li><a href=\"http://gaming.stackexchange.com\" title=\"passionate videogamers on all platforms\">Arqade (gaming)</a></li>\n" +
            "                        <li><a href=\"http://bicycles.stackexchange.com\" title=\"people who build and repair bicycles, people who train cycling, or commute on bicycles\">Bicycles</a></li>\n" +
            "                        <li><a href=\"http://rpg.stackexchange.com\" title=\"gamemasters and players of tabletop, paper-and-pencil role-playing games\">Role-playing Games</a></li>\n" +
            "\n" +
            "                        <li>\n" +
            "                            <a href=\"http://stackexchange.com/sites#culturerecreation\" class=\"more\">\n" +
            "                                more (21)\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                </ol>\n" +
            "            </td>\n" +
            "            <td>\n" +
            "                <ol>\n" +
            "                        <li><a href=\"http://math.stackexchange.com\" title=\"people studying math at any level and professionals in related fields\">Mathematics</a></li>\n" +
            "                        <li><a href=\"http://stats.stackexchange.com\" title=\"statisticians, data analysts, data miners and data visualization experts\">Cross Validated (stats)</a></li>\n" +
            "                        <li><a href=\"http://cstheory.stackexchange.com\" title=\"theoretical computer scientists and researchers in related fields\">Theoretical Computer Science</a></li>\n" +
            "                        <li><a href=\"http://physics.stackexchange.com\" title=\"active researchers, academics and students of physics\">Physics</a></li>\n" +
            "                        <li><a href=\"http://mathoverflow.net\" title=\"professional mathematicians\">MathOverflow</a></li>\n" +
            "\n" +
            "                        <li>\n" +
            "                            <a href=\"http://stackexchange.com/sites#science\" class=\"more\">\n" +
            "                                more (7)\n" +
            "                            </a>\n" +
            "                        </li>\n" +
            "                </ol>\n" +
            "            </td>\n" +
            "            <td>\n" +
            "                <ol>\n" +
            "                        <li><a href=\"http://stackapps.com\" title=\"apps, scripts, and development with the Stack Exchange API\">Stack Apps</a></li>\n" +
            "                        <li><a href=\"http://meta.stackoverflow.com\" title=\"meta-discussion of the Stack Exchange family of Q&amp;A websites\">Meta Stack Overflow</a></li>\n" +
            "                        <li><a href=\"http://area51.stackexchange.com\" title=\"proposing new sites in the Stack Exchange network\">Area 51</a></li>\n" +
            "                        <li><a href=\"http://careers.stackoverflow.com\">Stack Overflow Careers</a></li>\n" +
            "\n" +
            "                </ol>\n" +
            "            </td>\n" +
            "    </tr>\n" +
            "</table>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "\n" +
            "            <div id=\"copyright\">\n" +
            "                site design / logo &copy; 2013 stack exchange inc;\n" +
            "                user contributions licensed under <a href=\"http://creativecommons.org/licenses/by-sa/3.0/\" rel=\"license\">cc-wiki</a>\n" +
            "                with <a href=\"http://blog.stackoverflow.com/2009/06/attribution-required/\" rel=\"license\">attribution required</a>\n" +
            "            </div>\n" +
            "            <div id=\"footer-flair\">\n" +
            "                <a href=\"http://creativecommons.org/licenses/by-sa/3.0/\" class=\"cc-wiki-link\"></a>\n" +
            "            </div>\n" +
            "            <div id=\"svnrev\">\n" +
            "                rev 2013.8.28.977\n" +
            "            </div>\n" +
            "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <noscript>\n" +
            "        <div id=\"noscript-warning\">Electrical Engineering Stack Exchange works best with JavaScript enabled<img src=\"http://pixel.quantserve.com/pixel/p-c1rF4kxgLUzNc.gif\" alt=\"\" class=\"dno\"></div>\n" +
            "    </noscript>\n" +
            "\n" +
            "    <script type=\"text/javascript\">var _gaq=_gaq||[];_gaq.push(['_setAccount','UA-5620270-24']);\n" +
            "        _gaq.push(['_setDomainName','.stackexchange.com']);\n" +
            "_gaq.push(['_trackPageview']);\n" +
            "    var _qevents = _qevents || [];\n" +
            "    (function () {\n" +
            "        var ssl='https:'==document.location.protocol,\n" +
            "            s=document.getElementsByTagName('script')[0],\n" +
            "            ga=document.createElement('script');\n" +
            "        ga.type='text/javascript';\n" +
            "        ga.async=true;\n" +
            "        ga.src=(ssl?'https://ssl':'http://www')+'.google-analytics.com/ga.js';\n" +
            "        s.parentNode.insertBefore(ga,s);\n" +
            "        var sc=document.createElement('script');\n" +
            "        sc.type='text/javascript';\n" +
            "        sc.async=true;\n" +
            "        sc.src=(ssl?'https://secure':'http://edge')+'.quantserve.com/quant.js';\n" +
            "        s.parentNode.insertBefore(sc,s);\n" +
            "    })();\n" +
            "    _qevents.push({ qacct: \"p-c1rF4kxgLUzNc\" });\n" +
            "    </script>\n" +
            "\n" +
            "</body>\n" +
            "</html>";

    public static void main(String args[]) {
        String findTag = "(<\\s*(a)\\s+href\\s*=\\s*\"\\s*/\\s*questions\\s*/\\s*(\\d+)[^>]+\\s*>)(.+)(<\\s*/\\s*\\2>)";
        String findSpan = "(<\\s*(span)\\s+title=\"[^>]+>)([\\s\\d\\w:]+)(\\s*<\\s*/\\s*\\2\\s*>)";
        Scanner in = new Scanner(string);
        StringBuilder stringBuilder = new StringBuilder();
        while (in.hasNextLine()) {
            String html = in.nextLine();
            Pattern p = Pattern.compile(findTag, Pattern.MULTILINE);
            Matcher m = p.matcher(html);
            while (m.find()) {
                stringBuilder.append(m.group(3));
                stringBuilder.append(";");
                stringBuilder.append(m.group(4));
                stringBuilder.append(";");
            }
            Pattern p1 = Pattern.compile(findSpan, Pattern.MULTILINE);
            Matcher m1 = p1.matcher(html);
            if (m1.find()) {
                stringBuilder.append(m1.group(3)).append("\n");
            }
        }
        in.close();

        System.out.println(stringBuilder.toString());
    }
}
