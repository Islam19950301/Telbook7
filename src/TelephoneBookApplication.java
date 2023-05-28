import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TelephoneBookApplication {

    public static void main(String[] args) throws IOException, OperationException {

        System.err.println("Hello this is my phonebook");

        Scanner scanner = new Scanner(System.in);

        TelBook telBook = new TelBook();
        inputPage(telBook);

        ServerSocket server = new ServerSocket(8080);

        try {

            while (true) {


                Socket socket = server.accept();
                System.out.println("server connect");

                System.out.println("Menu: ");
                System.out.println("1 - Add page;");
                System.out.println("2 - Show all pages;");
                System.out.println("3 - Update page;");
                System.out.println("4 - Delete page;");
                System.out.println("5 - Search page;");

                System.out.println("Enter option: ");

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                int optionSelected = Integer.parseInt(reader.readLine());

                PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

                if (optionSelected == 1) {

                    Page page = createPage(scanner);
                    savePageToFile(page);
                    telBook.add(page);


                } else if (optionSelected == 2) {
                    printPages(telBook.getPages(), writer);

                } else if (optionSelected == 3) {

                    System.out.println("Enter page number to replace: ");
                    int pageIndex = Integer.parseInt(scanLineOrThrowException(scanner));

                    telBook.update(createPage(scanner), pageIndex);


                } else if (optionSelected == 4) {

                    int pageIndex = Integer.parseInt(reader.readLine());

                    telBook.delete(pageIndex);
                    deletePage(telBook.getPages());

                } else if (optionSelected == 5) {

                    System.out.println("Enter search keyWord:");
                    String keyWord = scanLineOrThrowException(scanner);

                    ListOfPages foundPages = telBook.search(keyWord);
                }

                writer.close();
                reader.close();
                socket.close();
            }

        } catch (ClientWantsToExitException e) {
            System.out.println("Thank you for using our software! See you later!");
            System.out.println("Exiting TelBook...");
        } catch (OperationException e) {
            System.err.println(e.getMessage());

        }
    }

    private static Page createPage(Scanner scanner) throws ClientWantsToExitException, OperationException {

        Person person = new Person();

        while (true) {

            System.out.println("Select info to fill: ");
            System.out.println("(name) Fill name");
            System.out.println("(birthday) Fill birthday");
            System.out.println("(gender) Fill gender");
            System.out.println("(education) Fill education");
            System.out.println("(tel) Fill mobile phone");
            System.out.println("(email) Fill email phone");
            System.out.println("(instagram) Fill instagram");
            System.out.println("(facebook) Fill facebook");
            System.out.println("(twitter) Fill twitter account");
            System.out.println("(done) Exit this menu");

            String infoType = scanLineOrThrowException(scanner);

            if (infoType.equals("tel")) {

                while (true) {

                    MobilePhone mobilePhone = new MobilePhone();

                    try {
                        System.out.println("-MobilePhone-");
                        System.out.println("Country Code:");
                        mobilePhone.setCountryCode(scanLineOrThrowException(scanner));
                        System.out.println("msisdn:");
                        mobilePhone.setMsisdn(scanLineOrThrowException(scanner));

                    } catch (NumberFormatException | OperationException e) {
                        System.err.println(e.getMessage());
                        System.out.println("Would you like to retry operation (Y/N)?");

                        String l = scanner.nextLine();

                        if (l.equals("Y")) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    person.addContact(mobilePhone);
                    break;
                }


            } else if (infoType.equals("name")) {

                while (true) {

                    Name name = new Name();


                    try {
                        System.out.println("-Name-");
                        System.out.println("firstname:");
                        name.setFirstname(scanLineOrThrowException(scanner));
                        System.out.println("surname:");
                        name.setSurname(scanLineOrThrowException(scanner));
                        System.out.println("paternal:");
                        name.setPaternal(scanLineOrThrowException(scanner));
                        System.out.println("maternal:");
                        name.setMaternal(scanLineOrThrowException(scanner));
                        System.out.println("prefix:");
                        name.setPrefix(scanLineOrThrowException(scanner));

                    } catch (NumberFormatException | OperationException e) {
                        System.err.println(e.getMessage());
                        System.out.println("Would you like to retry operation (Y/N)?");

                        String l = scanner.nextLine();

                        if (l.equals("Y")) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    person.addPersonalInfo(name);
                    break;
                }

            } else if (infoType.equals("birthday")) {


                while (true) {

                    Birthday birthday = new Birthday();

                    try {

                        System.out.println("-Birthday-");
                        System.out.println("day:");
                        birthday.setDay(Integer.parseInt(scanLineOrThrowException(scanner)));
                        System.out.println("month:");
                        birthday.setMonth(Integer.parseInt(scanLineOrThrowException(scanner)));
                        System.out.println("year:");
                        birthday.setYear(Integer.parseInt(scanLineOrThrowException(scanner)));

                    } catch (NumberFormatException | OperationException e) {

                        System.err.println(e.getMessage());
                        System.out.println("Would you like to retry operation (Y/N)?");

                        String l = scanner.nextLine();

                        if (l.equals("Y")) {
                            continue; //retry while loop from the start
                        } else {
                            break; //breaking while loop without calling person.addPersonalInfo(birthday)
                        }
                    }

                    person.addPersonalInfo(birthday);
                    break;
                }


            } else if (infoType.equals("twitter")) {

                while (true) {

                    TwitterAccount twitterAccount = new TwitterAccount();

                    try {
                        System.out.println("-TwitterAccount-");
                        System.out.println("user name:");
                        twitterAccount.setUsername(scanLineOrThrowException(scanner));
                    } catch (NumberFormatException | OperationException e) {

                        System.err.println(e.getMessage());
                        System.out.println("Would you like to retry operation (Y/N)?");

                        String l = scanner.nextLine();

                        if (l.equals("Y")) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    person.addContact(twitterAccount);
                    break;
                }

            } else if (infoType.equals("email")) {

                while ((true)) {

                    Email email = new Email();

                    try {
                        System.out.println("-Email-");
                        System.out.println("user name:");
                        email.setUsername(scanLineOrThrowException(scanner));
                        System.out.println("mail provider:");
                        email.setMailProvider(scanLineOrThrowException(scanner));
                    } catch (NumberFormatException | OperationException e) {

                        System.err.println(e.getMessage());
                        System.out.println("Would you like to retry operation (Y/N)?");

                        String l = scanner.nextLine();

                        if (l.equals("Y")) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    person.addContact(email);
                    break;
                }


            } else if (infoType.equals("education")) {

                while (true) {

                    Education education = new Education();

                    try {
                        System.out.println("-Education-");
                        System.out.println("city:");
                        education.setCity(scanLineOrThrowException(scanner));
                        System.out.println("country:");
                        education.setCountry(scanLineOrThrowException(scanner));
                        System.out.println("Institution:");
                        education.setInstitution(scanLineOrThrowException(scanner));
                        System.out.println("level:");
                        education.setLevel(scanLineOrThrowException(scanner));

                    } catch (NumberFormatException | OperationException e) {

                        System.err.println(e.getMessage());
                        System.out.println("Would you like to retry operation (Y/N)?");

                        String l = scanner.nextLine();

                        if (l.equals("Y")) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    person.addPersonalInfo(education);
                    break;
                }

            } else if (infoType.equals("facebook")) {

                while (true) {

                    FacebookAccount facebookAccount = new FacebookAccount();

                    try {
                        System.out.println("-FacebookAccount-");
                        System.out.println("");
                        facebookAccount.setUsername(scanLineOrThrowException(scanner));

                    } catch (NumberFormatException | OperationException e) {

                        System.err.println(e.getMessage());
                        System.out.println("Would you like to retry operation (Y/N)?");

                        String l = scanner.nextLine();

                        if (l.equals("Y")) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    person.addContact(facebookAccount);
                    break;

                }

            } else if (infoType.equals("gender")) {
                while (true) {

                    Gender gender = new Gender();

                    try {
                        System.out.println("-Gender-");
                        System.out.println("(m)ale/(f)emale:");
                        gender.setType(scanLineOrThrowException(scanner));

                    } catch (NumberFormatException | OperationException e) {

                        System.err.println(e.getMessage());
                        System.out.println("Would you like to retry operation (Y/N)?");

                        String l = scanner.nextLine();

                        if (l.equals("Y")) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    person.addPersonalInfo(gender);
                    break;
                }

            } else if (infoType.equals("instagram_account")) {

                while (true) {

                    InstagramAccount instagramAccount = new InstagramAccount();

                    try {
                        System.out.println("-Instagram Account-");
                        System.out.println("account:");
                        instagramAccount.setAccount(scanLineOrThrowException(scanner));

                    } catch (NumberFormatException | OperationException e) {

                        System.err.println(e.getMessage());
                        System.out.println("Would you like to retry operation (Y/N)?");

                        String l = scanner.nextLine();

                        if (l.equals("Y")) {
                            continue;
                        } else {
                            break;
                        }

                    }
                    person.addContact(instagramAccount);
                    break;
                }

            } else if (infoType.equals("profession")) {

                while (true) {

                    Profession profession = new Profession();

                    try {
                        System.out.println("-Profession-");
                        System.out.println("profession group:");
                        profession.setProfessionGroup(scanLineOrThrowException(scanner));
                        System.out.println("profession name:");
                        profession.setProfessionName(scanLineOrThrowException(scanner));

                    } catch (NumberFormatException | OperationException e) {

                        System.err.println(e.getMessage());
                        System.out.println("Would you like to retry operation (Y/N)?");

                        String l = scanner.nextLine();

                        if (l.equals("Y")) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    person.addPersonalInfo(profession);
                    break;
                }

            } else if (infoType.equals("done")) {
                break;
            }
        }

        OperationResult operationResult = null;

        return new Page(person);

    }


    private static String scanLineOrThrowException(Scanner scanner) throws ClientWantsToExitException {

        String val = scanner.nextLine();

        if (val.equals(":exit")) {
            throw new ClientWantsToExitException();
        }

        return val;
    }

    private static void printPages(ListOfPages pages, PrintWriter writer) throws IOException {


        int i = 0;

        while (i < pages.size()) {


            Page page = pages.get(i);
            Person person = page.getPerson();

            ListOfPersonalInfos personalInfos = person.getPersonalInfos();
            ListOfContacts contacts = person.getContacts();

            writer.write("Page#" + page.getPageNumber() + "\n");
            writer.flush();

            for (int j = 0; j < personalInfos.size(); j++) {
                writer.write(personalInfos.get(j).getPersonInfoAsString());
                writer.flush();
            }

            for (int j = 0; j < contacts.size(); j++) {
                writer.write(contacts.get(j).getContactAsString());
                writer.flush();
            }

            System.out.println();

            i++;
        }

        writer.close();
    }

    public static void savePageToFile(Page page) throws IOException {
        String fileOfName = "C:\\Users\\77007\\Рабочий стол\\Persons.txt";
        File file = new File(fileOfName);
        boolean fileTrue = file.createNewFile();
        FileOutputStream output = new FileOutputStream(fileOfName, true);

        Person person = page.getPerson();

        ListOfPersonalInfos personalInfos = person.getPersonalInfos();
        ListOfContacts contacts = person.getContacts();

        byte[] pageNumberByte = ("Page#" + page.getPageNumber() + "\n").getBytes();
        output.write(pageNumberByte);

        for (int i = 0; i < personalInfos.size(); i++) {
            byte[] personalInfosByte = personalInfos.get(i).getPersonInfoAsString().getBytes();
            output.write(personalInfosByte);
        }
        for (int i = 0; i < contacts.size(); i++) {
            byte[] contctsByte = contacts.get(i).getContactAsString().getBytes();
            output.write(contctsByte);
        }
        output.close();

    }

    public static void inputPage(TelBook telBook) throws IOException, OperationException {
        String fileOfName = "C:\\Users\\77007\\Рабочий стол\\Persons.txt";
        File file = new File(fileOfName);
        boolean fileName = file.createNewFile();
        BufferedReader buffered = new BufferedReader(new FileReader(fileOfName));
        String line = buffered.readLine();


        Person person = null;
        while (line != null) {

            if (line.startsWith("Page") || line.startsWith("last")) {
                if (person != null) {
                    Page page = new Page(person);
                    telBook.add(page);
                }
                if (line.startsWith("Page")) {
                    person = new Person();
                } else if (line.equals("last")) {
                    buffered.close();
                    break;
                }

            } else if (line.startsWith("Name")) {

                Name name = new Name();

                String[] nameSplit = line.split(" ");

                name.setFirstname(nameSplit[1]);
                name.setSurname(nameSplit[2]);
                name.setPaternal(nameSplit[3]);
                name.setMaternal(nameSplit[4]);
                name.setPrefix(nameSplit[5]);

                person.addPersonalInfo(name);
            } else if (line.startsWith("Birthday")) {

                Birthday birthday = new Birthday();

                String[] birthdaySplit = line.split("/");
                birthday.setDay(Integer.parseInt(birthdaySplit[1]));
                birthday.setMonth(Integer.parseInt(birthdaySplit[2]));
                birthday.setYear(Integer.parseInt(birthdaySplit[3]));

                person.addPersonalInfo(birthday);
            }

            line = buffered.readLine();
            if (line == null) {
                line = "last";
            }
        }
    }

    public static void deletePage(ListOfPages pages) throws IOException {
        String fileOfName = "C:\\Users\\77007\\Рабочий стол\\Persons.txt";
        File file = new File(fileOfName);
        FileOutputStream outputStream = new FileOutputStream(fileOfName);

        int i = 0;
        while (i < pages.size()) {

            Page page = pages.get(i);
            Person person = page.getPerson();

            ListOfPersonalInfos personalInfos = person.getPersonalInfos();
            ListOfContacts contacts = person.getContacts();

            byte[] pageNumber = ("Page#" + page.getPageNumber() + "\n").getBytes();
            outputStream.write(pageNumber);
            for (int j = 0; j < personalInfos.size(); j++) {
                byte[] personalInfoByte = personalInfos.get(i).getPersonInfoAsString().getBytes();
                outputStream.write(personalInfoByte);
            }

            for (int j = 0; j < contacts.size(); j++) {
                byte[] contactByte = contacts.get(i).getContactAsString().getBytes();
                outputStream.write(contactByte);
            }
            i++;
        }
        outputStream.close();

    }
}