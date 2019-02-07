package com.adam;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FilePartReaderTest {

    FilePartReader reader;

    @BeforeAll
    void init() {
        reader = new FilePartReader();
        reader.setup("/Users/adamgonda/IdeaProjects/current/filepartreader-testing-with-junit-AdamGonda/someTest.txt");
    }

    @Test
    void testRead() throws IOException {
        final String EXPECTED =
                "Abbbba kabba\n" + "mammmmmo monnnnyo bannnya\n" + "lkajsdf\n" + "\n" + "asdlfkjasdfl;kj lkajsdf;lkjasdf\n";

        assertEquals(EXPECTED, reader.read());
    }

    @Test
    void testReadLines() throws FileNotFoundException {
        final String EXPECTED = "Abbbba kabba";
        assertEquals(EXPECTED, reader.readLines(1,2));
    }

}