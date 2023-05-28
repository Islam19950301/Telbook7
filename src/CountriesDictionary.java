import java.util.Objects;

public class CountriesDictionary {

    private static final Country[] countries = new Country[]{
            new Country("-1","Afghanistan", "AF", "AFG", "004"),
            new Country("-1","Aland Islands", "AX", "ALA", "248"),
            new Country("-1","Albania", "AL", "ALB", "008"),
            new Country("-1","Algeria", "DZ", "DZA", "012"),
            new Country("-1","American Samoa", "AS", "ASM", "016"),
            new Country("-1","Andorra", "AD", "AND", "020"),
            new Country("-1","Angola", "AO", "AGO", "024"),
            new Country("-1","Anguilla", "AI", "AIA", "660"),
            new Country("-1","Antarctica", "AQ", "ATA", "010"),
            new Country("-1","Antigua and Barbuda", "AG", "ATG", "028"),
            new Country("-1","Argentina", "AR", "ARG", "032"),
            new Country("-1","Armenia", "AM", "ARM", "051"),
            new Country("-1","Aruba", "AW", "ABW", "533"),
            new Country("-1","Australia", "AU", "AUS", "036"),
            new Country("-1","Austria", "AT", "AUT", "040"),
            new Country("-1","Azerbaijan", "AZ", "AZE", "031"),
            new Country("-1","Bahamas", "BS", "BHS", "044"),
            new Country("-1","Bahrain", "BH", "BHR", "048"),
            new Country("-1","Bangladesh", "BD", "BGD", "050"),
            new Country("-1","Barbados", "BB", "BRB", "052"),
            new Country("-1","Belarus", "BY", "BLR", "112"),
            new Country("-1","Belgium", "BE", "BEL", "056"),
            new Country("-1","Belize", "BZ", "BLZ", "084"),
            new Country("-1","Benin", "BJ", "BEN", "204"),
            new Country("-1","Bermuda", "BM", "BMU", "060"),
            new Country("-1","Bhutan", "BT", "BTN", "064"),
            new Country("-1","Bolivia", "BO", "BOL", "068"),
            new Country("-1","Bosnia and Herzegovina", "BA", "BIH", "070"),
            new Country("-1","Botswana", "BW", "BWA", "072"),
            new Country("-1","Bouvet Island", "BV", "BVT", "074"),
            new Country("-1","Brazil", "BR", "BRA", "076"),
            new Country("-1","British Virgin Islands", "VG", "VGB", "092"),
            new Country("-1","British Indian Ocean Territory", "IO", "IOT", "086"),
            new Country("-1","Brunei Darussalam", "BN", "BRN", "096"),
            new Country("-1","Bulgaria", "BG", "BGR", "100"),
            new Country("-1","Burkina Faso", "BF", "BFA", "854"),
            new Country("-1","Burundi", "BI", "BDI", "108"),
            new Country("-1","Cambodia", "KH", "KHM", "116"),
            new Country("-1","Cameroon", "CM", "CMR", "120"),
            new Country("1","Canada", "CA", "CAN", "124"),
            new Country("-1","Cape Verde", "CV", "CPV", "132"),
            new Country("-1","Cayman Islands", "KY", "CYM", "136"),
            new Country("-1","Central African Republic", "CF", "CAF", "140"),
            new Country("-1","Chad", "TD", "TCD", "148"),
            new Country("-1","Chile", "CL", "CHL", "152"),
            new Country("-1","China", "CN", "CHN", "156"),
            new Country("-1","Hong Kong, SAR China", "HK", "HKG", "344"),
            new Country("-1","Macao, SAR China", "MO", "MAC", "446"),
            new Country("-1","Christmas Island", "CX", "CXR", "162"),
            new Country("-1","Cocos (Keeling) Islands", "CC", "CCK", "166"),
            new Country("-1","Colombia", "CO", "COL", "170"),
            new Country("-1","Comoros", "KM", "COM", "174"),
            new Country("-1","Congo (Brazzaville)", "CG", "COG", "178"),
            new Country("-1","Congo, (Kinshasa)", "CD", "COD", "180"),
            new Country("-1","Cook Islands", "CK", "COK", "184"),
            new Country("-1","Costa Rica", "CR", "CRI", "188"),
            new Country("-1","Côte d'Ivoire", "CI", "CIV", "384"),
            new Country("-1","Croatia", "HR", "HRV", "191"),
            new Country("-1","Cuba", "CU", "CUB", "192"),
            new Country("-1","Cyprus", "CY", "CYP", "196"),
            new Country("-1","Czech Republic", "CZ", "CZE", "203"),
            new Country("-1","Denmark", "DK", "DNK", "208"),
            new Country("-1","Djibouti", "DJ", "DJI", "262"),
            new Country("-1","Dominica", "DM", "DMA", "212"),
            new Country("-1","Dominican Republic", "DO", "DOM", "214"),
            new Country("-1","Ecuador", "EC", "ECU", "218"),
            new Country("-1","Egypt", "EG", "EGY", "818"),
            new Country("-1","El Salvador", "SV", "SLV", "222"),
            new Country("-1","Equatorial Guinea", "GQ", "GNQ", "226"),
            new Country("-1","Eritrea", "ER", "ERI", "232"),
            new Country("-1","Estonia", "EE", "EST", "233"),
            new Country("-1","Ethiopia", "ET", "ETH", "231"),
            new Country("-1","Falkland Islands (Malvinas)", "FK", "FLK", "238"),
            new Country("-1","Faroe Islands", "FO", "FRO", "234"),
            new Country("-1","Fiji", "FJ", "FJI", "242"),
            new Country("-1","Finland", "FI", "FIN", "246"),
            new Country("-1","France", "FR", "FRA", "250"),
            new Country("-1","French Guiana", "GF", "GUF", "254"),
            new Country("-1","French Polynesia", "PF", "PYF", "258"),
            new Country("-1","French Southern Territories", "TF", "ATF", "260"),
            new Country("-1","Gabon", "GA", "GAB", "266"),
            new Country("-1","Gambia", "GM", "GMB", "270"),
            new Country("-1","Georgia", "GE", "GEO", "268"),
            new Country("-1","Germany", "DE", "DEU", "276"),
            new Country("-1","Ghana", "GH", "GHA", "288"),
            new Country("-1","Gibraltar", "GI", "GIB", "292"),
            new Country("-1","Greece", "GR", "GRC", "300"),
            new Country("-1","Greenland", "GL", "GRL", "304"),
            new Country("-1","Grenada", "GD", "GRD", "308"),
            new Country("-1","Guadeloupe", "GP", "GLP", "312"),
            new Country("-1","Guam", "GU", "GUM", "316"),
            new Country("-1","Guatemala", "GT", "GTM", "320"),
            new Country("-1","Guernsey", "GG", "GGY", "831"),
            new Country("-1","Guinea", "GN", "GIN", "324"),
            new Country("-1","Guinea-Bissau", "GW", "GNB", "624"),
            new Country("-1","Guyana", "GY", "GUY", "328"),
            new Country("-1","Haiti", "HT", "HTI", "332"),
            new Country("-1","Heard and Mcdonald Islands", "HM", "HMD", "334"),
            new Country("-1","Holy See (Vatican City State)", "VA", "VAT", "336"),
            new Country("-1","Honduras", "HN", "HND", "340"),
            new Country("-1","Hungary", "HU", "HUN", "348"),
            new Country("-1","Iceland", "IS", "ISL", "352"),
            new Country("-1","India", "IN", "IND", "356"),
            new Country("-1","Indonesia", "ID", "IDN", "360"),
            new Country("-1","Iran, Islamic Republic of", "IR", "IRN", "364"),
            new Country("-1","Iraq", "IQ", "IRQ", "368"),
            new Country("-1","Ireland", "IE", "IRL", "372"),
            new Country("-1","Isle of Man", "IM", "IMN", "833"),
            new Country("-1","Israel", "IL", "ISR", "376"),
            new Country("-1","Italy", "IT", "ITA", "380"),
            new Country("-1","Jamaica", "JM", "JAM", "388"),
            new Country("-1","Japan", "JP", "JPN", "392"),
            new Country("-1","Jersey", "JE", "JEY", "832"),
            new Country("-1","Jordan", "JO", "JOR", "400"),
            new Country("7","Kazakhstan", "KZ", "KAZ", "398"),
            new Country("-1","Kenya", "KE", "KEN", "404"),
            new Country("-1","Kiribati", "KI", "KIR", "296"),
            new Country("-1","Korea (North)", "KP", "PRK", "408"),
            new Country("-1","Korea (South)", "KR", "KOR", "410"),
            new Country("-1","Kuwait", "KW", "KWT", "414"),
            new Country("-1","Kyrgyzstan", "KG", "KGZ", "417"),
            new Country("-1","Lao PDR", "LA", "LAO", "418"),
            new Country("-1","Latvia", "LV", "LVA", "428"),
            new Country("-1","Lebanon", "LB", "LBN", "422"),
            new Country("-1","Lesotho", "LS", "LSO", "426"),
            new Country("-1","Liberia", "LR", "LBR", "430"),
            new Country("-1","Libya", "LY", "LBY", "434"),
            new Country("-1","Liechtenstein", "LI", "LIE", "438"),
            new Country("-1","Lithuania", "LT", "LTU", "440"),
            new Country("-1","Luxembourg", "LU", "LUX", "442"),
            new Country("-1","Macedonia, Republic of", "MK", "MKD", "807"),
            new Country("-1","Madagascar", "MG", "MDG", "450"),
            new Country("-1","Malawi", "MW", "MWI", "454"),
            new Country("-1","Malaysia", "MY", "MYS", "458"),
            new Country("-1","Maldives", "MV", "MDV", "462"),
            new Country("-1","Mali", "ML", "MLI", "466"),
            new Country("-1","Malta", "MT", "MLT", "470"),
            new Country("-1","Marshall Islands", "MH", "MHL", "584"),
            new Country("-1","Martinique", "MQ", "MTQ", "474"),
            new Country("-1","Mauritania", "MR", "MRT", "478"),
            new Country("-1","Mauritius", "MU", "MUS", "480"),
            new Country("-1","Mayotte", "YT", "MYT", "175"),
            new Country("-1","Mexico", "MX", "MEX", "484"),
            new Country("-1","Micronesia, Federated States of", "FM", "FSM", "583"),
            new Country("-1","Moldova", "MD", "MDA", "498"),
            new Country("-1","Monaco", "MC", "MCO", "492"),
            new Country("-1","Mongolia", "MN", "MNG", "496"),
            new Country("-1","Montenegro", "ME", "MNE", "499"),
            new Country("-1","Montserrat", "MS", "MSR", "500"),
            new Country("-1","Morocco", "MA", "MAR", "504"),
            new Country("-1","Mozambique", "MZ", "MOZ", "508"),
            new Country("-1","Myanmar", "MM", "MMR", "104"),
            new Country("-1","Namibia", "NA", "NAM", "516"),
            new Country("-1","Nauru", "NR", "NRU", "520"),
            new Country("-1","Nepal", "NP", "NPL", "524"),
            new Country("-1","Netherlands", "NL", "NLD", "528"),
            new Country("-1","Netherlands Antilles", "AN", "ANT", "530"),
            new Country("-1","New Caledonia", "NC", "NCL", "540"),
            new Country("64","New Zealand", "NZ", "NZL", "554"),
            new Country("-1","Nicaragua", "NI", "NIC", "558"),
            new Country("-1","Niger", "NE", "NER", "562"),
            new Country("-1","Nigeria", "NG", "NGA", "566"),
            new Country("-1","Niue", "NU", "NIU", "570"),
            new Country("-1","Norfolk Island", "NF", "NFK", "574"),
            new Country("-1","Northern Mariana Islands", "MP", "MNP", "580"),
            new Country("-1","Norway", "NO", "NOR", "578"),
            new Country("-1","Oman", "OM", "OMN", "512"),
            new Country("-1","Pakistan", "PK", "PAK", "586"),
            new Country("-1","Palau", "PW", "PLW", "585"),
            new Country("-1","Palestinian Territory", "PS", "PSE", "275"),
            new Country("-1","Panama", "PA", "PAN", "591"),
            new Country("-1","Papua New Guinea", "PG", "PNG", "598"),
            new Country("-1","Paraguay", "PY", "PRY", "600"),
            new Country("-1","Peru", "PE", "PER", "604"),
            new Country("-1","Philippines", "PH", "PHL", "608"),
            new Country("-1","Pitcairn", "PN", "PCN", "612"),
            new Country("-1","Poland", "PL", "POL", "616"),
            new Country("-1","Portugal", "PT", "PRT", "620"),
            new Country("-1","Puerto Rico", "PR", "PRI", "630"),
            new Country("-1","Qatar", "QA", "QAT", "634"),
            new Country("-1","Réunion", "RE", "REU", "638"),
            new Country("-1","Romania", "RO", "ROU", "642"),
            new Country("7","Russian Federation", "RU", "RUS", "643"),
            new Country("-1","Rwanda", "RW", "RWA", "646"),
            new Country("-1","Saint-Barthélemy", "BL", "BLM", "652"),
            new Country("-1","Saint Helena", "SH", "SHN", "654"),
            new Country("-1","Saint Kitts and Nevis", "KN", "KNA", "659"),
            new Country("-1","Saint Lucia", "LC", "LCA", "662"),
            new Country("-1","Saint-Martin (French part)", "MF", "MAF", "663"),
            new Country("-1","Saint Pierre and Miquelon", "PM", "SPM", "666"),
            new Country("-1","Saint Vincent and Grenadines", "VC", "VCT", "670"),
            new Country("-1","Samoa", "WS", "WSM", "882"),
            new Country("-1","San Marino", "SM", "SMR", "674"),
            new Country("-1","Sao Tome and Principe", "ST", "STP", "678"),
            new Country("-1","Saudi Arabia", "SA", "SAU", "682"),
            new Country("-1","Senegal", "SN", "SEN", "686"),
            new Country("-1","Serbia", "RS", "SRB", "688"),
            new Country("-1","Seychelles", "SC", "SYC", "690"),
            new Country("-1","Sierra Leone", "SL", "SLE", "694"),
            new Country("-1","Singapore", "SG", "SGP", "702"),
            new Country("-1","Slovakia", "SK", "SVK", "703"),
            new Country("-1","Slovenia", "SI", "SVN", "705"),
            new Country("-1","Solomon Islands", "SB", "SLB", "090"),
            new Country("-1","Somalia", "SO", "SOM", "706"),
            new Country("-1","South Africa", "ZA", "ZAF", "710"),
            new Country("-1","South Georgia and the South Sandwich Islands", "GS", "SGS", "239"),
            new Country("-1","South Sudan", "SS", "SSD", "728"),
            new Country("-1","Spain", "ES", "ESP", "724"),
            new Country("-1","Sri Lanka", "LK", "LKA", "144"),
            new Country("-1","Sudan", "SD", "SDN", "736"),
            new Country("-1","Suriname", "SR", "SUR", "740"),
            new Country("-1","Svalbard and Jan Mayen Islands", "SJ", "SJM", "744"),
            new Country("-1","Swaziland", "SZ", "SWZ", "748"),
            new Country("-1","Sweden", "SE", "SWE", "752"),
            new Country("-1","Switzerland", "CH", "CHE", "756"),
            new Country("-1","Syrian Arab Republic (Syria)", "SY", "SYR", "760"),
            new Country("-1","Taiwan, Republic of China", "TW", "TWN", "158"),
            new Country("-1","Tajikistan", "TJ", "TJK", "762"),
            new Country("-1","Tanzania, United Republic of", "TZ", "TZA", "834"),
            new Country("-1","Thailand", "TH", "THA", "764"),
            new Country("-1","Timor-Leste", "TL", "TLS", "626"),
            new Country("-1","Togo", "TG", "TGO", "768"),
            new Country("-1","Tokelau", "TK", "TKL", "772"),
            new Country("-1","Tonga", "TO", "TON", "776"),
            new Country("-1","Trinidad and Tobago", "TT", "TTO", "780"),
            new Country("-1","Tunisia", "TN", "TUN", "788"),
            new Country("90","Turkey", "TR", "TUR", "792"),
            new Country("-1","Turkmenistan", "TM", "TKM", "795"),
            new Country("-1","Turks and Caicos Islands", "TC", "TCA", "796"),
            new Country("-1","Tuvalu", "TV", "TUV", "798"),
            new Country("-1","Uganda", "UG", "UGA", "800"),
            new Country("-1","Ukraine", "UA", "UKR", "804"),
            new Country("-1","United Arab Emirates", "AE", "ARE", "784"),
            new Country("-1","United Kingdom", "GB", "GBR", "826"),
            new Country("1","United States of America", "US", "USA", "840"),
            new Country("-1","US Minor Outlying Islands", "UM", "UMI", "581"),
            new Country("-1","Uruguay", "UY", "URY", "858"),
            new Country("-1","Uzbekistan", "UZ", "UZB", "860"),
            new Country("-1","Vanuatu", "VU", "VUT", "548"),
            new Country("-1","Venezuela (Bolivarian Republic)", "VE", "VEN", "862"),
            new Country("-1","Viet Nam", "VN", "VNM", "704"),
            new Country("-1","Virgin Islands, US", "VI", "VIR", "850"),
            new Country("-1","Wallis and Futuna Islands", "WF", "WLF", "876"),
            new Country("-1","Western Sahara", "EH", "ESH", "732"),
            new Country("-1","Yemen", "YE", "YEM", "887"),
            new Country("-1","Zambia", "ZM", "ZMB", "894"),
            new Country("-1","Zimbabwe", "ZW", "ZWE", "716")};

    public static Country getCountryByName(String name) {

        if (Objects.nonNull(name) && !name.isEmpty()) {

            for (int i = 0; i < countries.length; i++) {
                if (countries[i].getName().equalsIgnoreCase(name.trim())) {
                    return countries[i];
                }
            }
        }

        return null;
    }

    public static Country getCountryByPhoneCode(String phoneCode) {

        if (Objects.nonNull(phoneCode) && !phoneCode.isEmpty()) {

            for (int i = 0; i < countries.length; i++) {
                if (countries[i].getPhoneCode().equalsIgnoreCase(phoneCode.trim())) {
                    return countries[i];
                }
            }
        }

        return null;
    }
}