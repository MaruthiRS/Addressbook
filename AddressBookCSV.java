package com.bl.addressbook;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.bl.addressbook.AddressBook.contactList;

public class AddressBookCSV {
    /**
     *
     * @purpose: to read data from CSV file.
     * @param: writeDataToCSV.
     *
     * @throws IOException
     * @throws CsvRequiredFieldEmptyException
     * @throws CsvDataTypeMismatchException
     */
    public static void writeDataToCSV() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        try (Writer writer = Files.newBufferedWriter(Paths.get("Contacts.csv"));) {
            StatefulBeanToCsvBuilder<Contacts> builder = new StatefulBeanToCsvBuilder<>(writer);
            StatefulBeanToCsv<Contacts> beanWriter = builder.build();
            beanWriter.write(contactList);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @purpose: to read data from CSV file.
     * @param: readDataToCSV
     *
     *  @throws IOException
     */
    public static void readDataToCSV() throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get("Contacts.csv"));

             CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();) {

            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("First Name = " + nextRecord[2]);
                System.out.println("Last Name = " + nextRecord[3]);
                System.out.println("City = " + nextRecord[0]);
                System.out.println("State = " + nextRecord[6]);
                System.out.println("Email = " + nextRecord[1]);
                System.out.println("Phone Number = " + nextRecord[4]);
                System.out.println("Zip Code = " + nextRecord[5]);
            }
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }
}