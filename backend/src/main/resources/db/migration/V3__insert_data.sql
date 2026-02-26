BEGIN;

INSERT INTO T_QUIZ (ID,TITLE,DESCRIPTION,TAGS,THUMBNAIL) VALUES ('25e6d0ed-ee20-452b-8b33-b470365307f6','Quiz HTML','Test your HTML knowledge with this interactive quiz! Explore topics such as basic structure, elements and attributes, and forms. Each question is designed to assess and strengthen your web development skills with HTML.','HTML;WEB','https://freecoursesites.com/wp-content/uploads/2022/08/A-Quick-Guide-to-HTML-for-Complete-Newbies.jpg');
INSERT INTO T_QUIZ_QUESTION (ID,QUIZ_ID,QUESTION,OPTIONS,ANSWER_INDEX) VALUES ('d3b625dd-2c36-446b-8249-be6cb163488f','25e6d0ed-ee20-452b-8b33-b470365307f6','Which tag is used to insert an image?','<img>;<image>;<pic>;<src>',0);
INSERT INTO T_QUIZ_QUESTION (ID,QUIZ_ID,QUESTION,OPTIONS,ANSWER_INDEX) VALUES ('bf3a67c1-3192-41b2-b5a7-74f5b8e74c3a','25e6d0ed-ee20-452b-8b33-b470365307f6','Which tag is used to insert a paragraph?','<p>;<para>;<text>;<paragraph>',0);
INSERT INTO T_QUIZ_QUESTION (ID,QUIZ_ID,QUESTION,OPTIONS,ANSWER_INDEX) VALUES ('72932930-88d7-4cea-b51c-c2a1998e88e2','25e6d0ed-ee20-452b-8b33-b470365307f6','Which tag is used to insert a line break?','<br>;<break>;<lb>;<newline>',0);

COMMIT;