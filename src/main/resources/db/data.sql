INSERT INTO "appointments" (id, room_number, date, patientsid, employeesid) VALUES (1, '1.06', '2021-02-20', 1, 'D001');
INSERT INTO "appointments" (id, room_number, date, patientsid, employeesid) VALUES (2, '0.04', '2021-01-30', 2, 'D001');
INSERT INTO "appointments" (id, room_number, date, patientsid, employeesid) VALUES (3, '0.10', '2021-02-01', 3, 'D002');
INSERT INTO public.appointments (id, room_number, date, patientsid, employeesid) VALUES (4, '0.10', '2021-02-01', 4, 'D002');
INSERT INTO public.appointments (id, room_number, date, patientsid, employeesid) VALUES (5, '0.12', '2021-02-04', 5, 'D003');
INSERT INTO public.appointments (id, room_number, date, patientsid, employeesid) VALUES (6, '1.23', '2021-01-22', 6, 'D003');
INSERT INTO public.appointments (id, room_number, date, patientsid, employeesid) VALUES (7, '1.21', '2021-01-11', 7, 'D002');


--
-- TOC entry 3148 (class 0 OID 16881)
-- Dependencies: 216
-- Data for Name: companies; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.companies (id, company_name, nip, address, city, postcode) VALUES (1, 'MAX-POL', 1232151234123, 'Zielona 12', 'Wrocław', '43-324');
INSERT INTO public.companies (id, company_name, nip, address, city, postcode) VALUES (2, 'BUD-POL', 1251257644231, NULL, NULL, NULL);
INSERT INTO public.companies (id, company_name, nip, address, city, postcode) VALUES (3, 'EURO-MAX', 895467835434, NULL, NULL, NULL);
INSERT INTO public.companies (id, company_name, nip, address, city, postcode) VALUES (4, 'DM STUDIO', 78463274324, 'Czerwona 12a', 'Katowice', '44-353');


--
-- TOC entry 3151 (class 0 OID 16905)
-- Dependencies: 219
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.employees (id, first_name, last_name, license_id, is_active, hire_date, salary, address, city, postcode, phone_number, email_address, usersid, specialisation) VALUES ('LW002', 'Michał', 'Dunat', NULL, true, '2019-01-01', 2134, NULL, NULL, NULL, '6001023454', 'micdun@lab.com', 8, NULL);
INSERT INTO public.employees (id, first_name, last_name, license_id, is_active, hire_date, salary, address, city, postcode, phone_number, email_address, usersid, specialisation) VALUES ('CW001', 'Błażej', 'Ułaniewicz', NULL, true, '2010-01-01', 1334, NULL, NULL, NULL, '600102300', 'blaula@clinic.com', 9, NULL);
INSERT INTO public.employees (id, first_name, last_name, license_id, is_active, hire_date, salary, address, city, postcode, phone_number, email_address, usersid, specialisation) VALUES ('CW002', 'Helga', 'Hawska', NULL, false, '2001-01-01', NULL, NULL, NULL, NULL, '600102300', 'helhaw@clinic.com', 12, NULL);
INSERT INTO public.employees (id, first_name, last_name, license_id, is_active, hire_date, salary, address, city, postcode, phone_number, email_address, usersid, specialisation) VALUES ('LW001', 'Karolina', 'Olszewka', NULL, true, '2015-03-31', 2555, NULL, NULL, NULL, '600108234', 'karols@lab.com', 7, NULL);
INSERT INTO public.employees (id, first_name, last_name, license_id, is_active, hire_date, salary, address, city, postcode, phone_number, email_address, usersid, specialisation) VALUES ('D001', 'Kamil', 'Hulewicz', '1231521', true, '2015-09-01', 4500, 'Głęboka 3', 'Wrocław', '44-200', '694823412', 'kamhul@doctor.com', 4, 'Neurolog');
INSERT INTO public.employees (id, first_name, last_name, license_id, is_active, hire_date, salary, address, city, postcode, phone_number, email_address, usersid, specialisation) VALUES ('D002', 'Artur', 'Sołtys', '453243', true, '2018-01-31', 3500, 'Czekoladowa 32', 'Rybnik', '44-270', '68244342', 'artsol@doctor.com', 11, 'Dermatolog');
INSERT INTO public.employees (id, first_name, last_name, license_id, is_active, hire_date, salary, address, city, postcode, phone_number, email_address, usersid, specialisation) VALUES ('D003', 'Monika', 'Makowska', NULL, true, '2010-05-31', 4233.33, NULL, NULL, NULL, '600190234', 'monmak@doctor.com', 13, 'Dermatolog');
INSERT INTO public.employees (id, first_name, last_name, license_id, is_active, hire_date, salary, address, city, postcode, phone_number, email_address, usersid, specialisation) VALUES ('D004', 'Marcin', 'Wójcik', NULL, false, '2005-03-31', NULL, NULL, NULL, NULL, '600190234', 'monmak@doctor.com', 16, 'Pediatra');
INSERT INTO public.employees (id, first_name, last_name, license_id, is_active, hire_date, salary, address, city, postcode, phone_number, email_address, usersid, specialisation) VALUES ('D005', 'Adrianna', 'Zysek', '12402134', true, '2020-11-23', 5000, 'Gruszkowa 12', 'Zabrze', '44-234', '6002321412', 'adrzys@doc.com', 20, 'Stomatolog');


--
-- TOC entry 3144 (class 0 OID 16862)
-- Dependencies: 212
-- Data for Name: invoices; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.invoices (id, invoice) VALUES (1, '\x66696c653a2f2f2f443a2f46616b747572792f46616b7475726131');
INSERT INTO public.invoices (id, invoice) VALUES (2, '\x66696c653a2f2f2f443a2f46616b747572792f46616b7475726132');
INSERT INTO public.invoices (id, invoice) VALUES (3, '\x66696c653a2f2f2f443a2f46616b747572792f46616b74757261332e706466');
INSERT INTO public.invoices (id, invoice) VALUES (4, '\x66696c653a2f2f2f443a2f46616b747572792f46616b74757261342e706466');


--
-- TOC entry 3138 (class 0 OID 16832)
-- Dependencies: 206
-- Data for Name: medical_records; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.medical_records (id, description, date, attachment, patientsid, employeesid) VALUES (2, 'no ogólnie to nie jest kolorowo', '2020-11-23', NULL, 1, 'D001');
INSERT INTO public.medical_records (id, description, date, attachment, patientsid, employeesid) VALUES (1, 'Katar', '2020-11-20', NULL, 1, 'D001');
INSERT INTO public.medical_records (id, description, date, attachment, patientsid, employeesid) VALUES (3, 'Kaszel', '2020-11-21', NULL, 4, 'D001');
INSERT INTO public.medical_records (id, description, date, attachment, patientsid, employeesid) VALUES (4, 'Ból głowy', '2020-10-21', NULL, 6, 'D002');
INSERT INTO public.medical_records (id, description, date, attachment, patientsid, employeesid) VALUES (5, 'Koronawirus', '2020-11-11', NULL, 8, 'D001');
INSERT INTO public.medical_records (id, description, date, attachment, patientsid, employeesid) VALUES (6, 'Cukrzyca', '2020-11-19', '\x6174746163686d656e74', 9, 'D005');
INSERT INTO public.medical_records (id, description, date, attachment, patientsid, employeesid) VALUES (7, 'Miażdżyca', '2020-11-29', '\x66696c65', 10, 'D004');
INSERT INTO public.medical_records (id, description, date, attachment, patientsid, employeesid) VALUES (8, 'Zakażenie', '2020-10-29', '\x66696c65', 1, 'D001');
INSERT INTO public.medical_records (id, description, date, attachment, patientsid, employeesid) VALUES (10, 'Coś tam', '2020-11-23', NULL, 6, 'D003');
INSERT INTO public.medical_records (id, description, date, attachment, patientsid, employeesid) VALUES (9, 'Blabla', '2020-10-12', NULL, 2, 'D001');
INSERT INTO public.medical_records (id, description, date, attachment, patientsid, employeesid) VALUES (11, 'Wątroba jak nowa', '2020-11-23', NULL, 6, 'D002');


--
-- TOC entry 3135 (class 0 OID 16813)
-- Dependencies: 203
-- Data for Name: notifications; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.notifications (id, description, date, patientsid) VALUES (1, 'Wizyta 20.12.20r.', '2020-12-19', 1);
INSERT INTO public.notifications (id, description, date, patientsid) VALUES (2, 'Wizyta 30.11.20r.', '2020-11-30', 2);
INSERT INTO public.notifications (id, description, date, patientsid) VALUES (3, 'Wizyta 1.12.20r.', '2020-12-01', 3);
INSERT INTO public.notifications (id, description, date, patientsid) VALUES (4, 'Wizyta 1.12.20r.', '2020-12-01', 4);
INSERT INTO public.notifications (id, description, date, patientsid) VALUES (5, 'Wizyta 1.12.20r.', '2020-12-01', 5);
INSERT INTO public.notifications (id, description, date, patientsid) VALUES (6, 'Wizyta 2.12.20r.', '2020-12-01', 6);
INSERT INTO public.notifications (id, description, date, patientsid) VALUES (7, 'Wizyta 2.12.20r.', '2020-12-02', 7);


--
-- TOC entry 3142 (class 0 OID 16854)
-- Dependencies: 210
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.orders (id, patientsid, paymentsid, employeesid) VALUES (1, 1, 1, 'CW001');
INSERT INTO public.orders (id, patientsid, paymentsid, employeesid) VALUES (2, 2, 3, 'CW001');
INSERT INTO public.orders (id, patientsid, paymentsid, employeesid) VALUES (3, 4, 6, 'CW002');
INSERT INTO public.orders (id, patientsid, paymentsid, employeesid) VALUES (4, 5, 2, 'CW002');
INSERT INTO public.orders (id, patientsid, paymentsid, employeesid) VALUES (5, 8, 8, 'CW001');
INSERT INTO public.orders (id, patientsid, paymentsid, employeesid) VALUES (6, 10, 9, 'CW001');
INSERT INTO public.orders (id, patientsid, paymentsid, employeesid) VALUES (7, 6, 7, 'CW001');


--
-- TOC entry 3152 (class 0 OID 16921)
-- Dependencies: 220
-- Data for Name: orders_services; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.orders_services (ordersid, servicesid) VALUES (1, 1);
INSERT INTO public.orders_services (ordersid, servicesid) VALUES (2, 2);
INSERT INTO public.orders_services (ordersid, servicesid) VALUES (3, 4);
INSERT INTO public.orders_services (ordersid, servicesid) VALUES (4, 5);
INSERT INTO public.orders_services (ordersid, servicesid) VALUES (5, 7);
INSERT INTO public.orders_services (ordersid, servicesid) VALUES (7, 5);


--
-- TOC entry 3133 (class 0 OID 16802)
-- Dependencies: 201
-- Data for Name: patients; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.patients (id, first_name, last_name, birth_date, blood_type, address, city, postcode, permanent_address, pemanent_city, permanent_postcode, phone_number, contact_phone, email_address, usersid, notifications_status) VALUES (1, 'Paweł', 'Maciończyk', '1999-09-08', 'A+', 'Tęczowa 42', 'Wrocław', '43-534', NULL, NULL, NULL, '692435642', NULL, NULL, 1, true);
INSERT INTO public.patients (id, first_name, last_name, birth_date, blood_type, address, city, postcode, permanent_address, pemanent_city, permanent_postcode, phone_number, contact_phone, email_address, usersid, notifications_status) VALUES (2, 'Piotr', 'Gorczyca', '2002-10-18', NULL, 'Miła 89', 'Zielona Góra', '34-535', NULL, NULL, NULL, '987234123', NULL, NULL, 2, NULL);
INSERT INTO public.patients (id, first_name, last_name, birth_date, blood_type, address, city, postcode, permanent_address, pemanent_city, permanent_postcode, phone_number, contact_phone, email_address, usersid, notifications_status) VALUES (3, 'Beata', 'Trytkiewicz', '1980-01-12', NULL, 'Wesoła 23', 'Poznań', '53-324', NULL, NULL, NULL, '984345324', NULL, NULL, 3, false);
INSERT INTO public.patients (id, first_name, last_name, birth_date, blood_type, address, city, postcode, permanent_address, pemanent_city, permanent_postcode, phone_number, contact_phone, email_address, usersid, notifications_status) VALUES (4, 'Paulina', 'Lisowska', '1940-05-20', NULL, 'Krótka 45', 'Gdańsk', '53-23', NULL, NULL, NULL, '9843425324', NULL, NULL, 6, NULL);
INSERT INTO public.patients (id, first_name, last_name, birth_date, blood_type, address, city, postcode, permanent_address, pemanent_city, permanent_postcode, phone_number, contact_phone, email_address, usersid, notifications_status) VALUES (5, 'Dawid', 'Dopurt', '1990-08-22', 'B-', 'Ciasna 5', 'Warszawa', '51-23', NULL, NULL, NULL, '9843425324', NULL, NULL, 10, false);
INSERT INTO public.patients (id, first_name, last_name, birth_date, blood_type, address, city, postcode, permanent_address, pemanent_city, permanent_postcode, phone_number, contact_phone, email_address, usersid, notifications_status) VALUES (6, 'Marcin', 'Marek', '1992-09-02', NULL, 'Długa 48', 'Warszawa', '41-223', NULL, NULL, NULL, '1234425324', NULL, NULL, 14, NULL);
INSERT INTO public.patients (id, first_name, last_name, birth_date, blood_type, address, city, postcode, permanent_address, pemanent_city, permanent_postcode, phone_number, contact_phone, email_address, usersid, notifications_status) VALUES (7, 'Marcin', 'Polański', '1999-02-07', 'AB+', 'Śmieszna 28', 'Rybnik', '40-273', NULL, NULL, NULL, '6798432412', NULL, NULL, 15, NULL);
INSERT INTO public.patients (id, first_name, last_name, birth_date, blood_type, address, city, postcode, permanent_address, pemanent_city, permanent_postcode, phone_number, contact_phone, email_address, usersid, notifications_status) VALUES (8, 'Teresa', 'Pawłowska', '1959-02-07', 'A+', '3. Maja 28', 'Wrocław', '44-273', NULL, NULL, NULL, '6798400212', NULL, NULL, 17, true);
INSERT INTO public.patients (id, first_name, last_name, birth_date, blood_type, address, city, postcode, permanent_address, pemanent_city, permanent_postcode, phone_number, contact_phone, email_address, usersid, notifications_status) VALUES (9, 'Jolanta', 'Mytek', '1998-07-03', NULL, 'Wąska 28/5', 'Katowice', '40-222', NULL, NULL, NULL, '6742344123', NULL, NULL, 18, true);
INSERT INTO public.patients (id, first_name, last_name, birth_date, blood_type, address, city, postcode, permanent_address, pemanent_city, permanent_postcode, phone_number, contact_phone, email_address, usersid, notifications_status) VALUES (10, 'Tomasz', 'Tomczyk', '1978-01-01', NULL, 'Szeroka 23d', 'Wrocław', '50-222', NULL, NULL, NULL, '600044123', NULL, 'tomtom@gmail.com', 19, NULL);
INSERT INTO public.patients (id, first_name, last_name, birth_date, blood_type, address, city, postcode, permanent_address, pemanent_city, permanent_postcode, phone_number, contact_phone, email_address, usersid, notifications_status) VALUES (11, 'Renata', 'Biedronka', '1942-04-30', '0-', 'Żółta 1d', 'Katowice', '44-222', NULL, NULL, NULL, '609000233', NULL, NULL, 21, true);


--
-- TOC entry 3146 (class 0 OID 16873)
-- Dependencies: 214
-- Data for Name: payments; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.payments (id, date, payment_method, payment_status, total_price, patientsid, companiesid, employeesid, invoicesid) VALUES (1, '2020-10-23', 'Cash', 'Success', 13.0, 2, NULL, 'CW001', NULL);
INSERT INTO public.payments (id, date, payment_method, payment_status, total_price, patientsid, companiesid, employeesid, invoicesid) VALUES (2, '2020-11-03', 'Credit card', 'Canceled', 34.0, 3, NULL, 'CW002', NULL);
INSERT INTO public.payments (id, date, payment_method, payment_status, total_price, patientsid, companiesid, employeesid, invoicesid) VALUES (3, '2020-11-08', 'Debit card', 'Rejected', 24.0, 5, NULL, 'CW001', NULL);
INSERT INTO public.payments (id, date, payment_method, payment_status, total_price, patientsid, companiesid, employeesid, invoicesid) VALUES (5, '2020-11-09', NULL, NULL, 4.0, 6, NULL, 'CW001', NULL);
INSERT INTO public.payments (id, date, payment_method, payment_status, total_price, patientsid, companiesid, employeesid, invoicesid) VALUES (6, '2020-11-11', 'Mobile payment', 'Pending', 53.0, 8, 1, 'CW001', 1);
INSERT INTO public.payments (id, date, payment_method, payment_status, total_price, patientsid, companiesid, employeesid, invoicesid) VALUES (7, '2020-11-14', 'Electronic bank transfer', 'Complete', 14.0, 2, 2, 'CW002', 2);
INSERT INTO public.payments (id, date, payment_method, payment_status, total_price, patientsid, companiesid, employeesid, invoicesid) VALUES (8, '2020-11-11', 'Mobile payment', 'Pending', 23.0, 1, NULL, 'CW001', NULL);
INSERT INTO public.payments (id, date, payment_method, payment_status, total_price, patientsid, companiesid, employeesid, invoicesid) VALUES (9, '2020-11-11', 'Mobile payment', 'Pending', 23.0, 2, NULL, 'CW002', NULL);


--
-- TOC entry 3136 (class 0 OID 16822)
-- Dependencies: 204
-- Data for Name: prescriptions; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.prescriptions (id, date, description, patientsid, employeesid) VALUES ('1', '2020-10-23', 'Różne leki', 1, 'D001');
INSERT INTO public.prescriptions (id, date, description, patientsid, employeesid) VALUES ('2', '2020-10-29', 'APAP', 2, 'D001');
INSERT INTO public.prescriptions (id, date, description, patientsid, employeesid) VALUES ('3', '2020-11-20', 'Ibuprom', 3, 'D003');
INSERT INTO public.prescriptions (id, date, description, patientsid, employeesid) VALUES ('4', '2020-11-20', 'Ibuprom', 4, 'D003');
INSERT INTO public.prescriptions (id, date, description, patientsid, employeesid) VALUES ('5', '2020-11-22', 'Pyralgina', 1, 'D002');
INSERT INTO public.prescriptions (id, date, description, patientsid, employeesid) VALUES ('6', '2020-11-12', 'Entyrox', 8, 'D003');
INSERT INTO public.prescriptions (id, date, description, patientsid, employeesid) VALUES ('100', '2020-10-28', 'Opis recepty wygląda następująco...', 3, 'D001');


--
-- TOC entry 3140 (class 0 OID 16843)
-- Dependencies: 208
-- Data for Name: services; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.services (id, service_name, price, service_description) VALUES (1, 'Pobranie krwi', 10.5, 'Bardzo delikatne pobranie krwi');
INSERT INTO public.services (id, service_name, price, service_description) VALUES (2, 'Badanie moczu', 5.5, 'W skład badania wchodzą: ...');
INSERT INTO public.services (id, service_name, price, service_description) VALUES (3, 'Badanie kału', NULL, NULL);
INSERT INTO public.services (id, service_name, price, service_description) VALUES (4, 'ALAT', 2.5, NULL);
INSERT INTO public.services (id, service_name, price, service_description) VALUES (5, 'ASPAT', 4.5, NULL);
INSERT INTO public.services (id, service_name, price, service_description) VALUES (6, 'Glukoza', 7.5, 'Badanie wykonane glukometrem');
INSERT INTO public.services (id, service_name, price, service_description) VALUES (7, 'Covid-19', NULL, NULL);
INSERT INTO public.services (id, service_name, price, service_description) VALUES (8, 'Alergeny', 44.5, 'Składa się z 40 alergenów');

INSERT INTO public.roles (id, role) VALUES (1,'ROLE_ADMIN');
INSERT INTO public.roles (id, role) VALUES (2,'ROLE_PATIENT');
INSERT INTO public.roles (id, role) VALUES (3,'ROLE_LABWORKER');
INSERT INTO public.roles (id, role) VALUES (4,'ROLE_CLINICWORKER');
INSERT INTO public.roles (id, role) VALUES (5,'ROLE_DOCTOR');
--
-- TOC entry 3150 (class 0 OID 16894)
-- Dependencies: 218
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (1, 'PawMac', 'haslo', 2, '98048421543');
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (2, 'PioGor', 'haslo', 2, '98048434543');
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (3, 'BeaTry', '123', 2,   '99048434543');
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (4, 'KamHul', 'XDDD', 5,  NULL);
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (5, 'admin', 'admin', 1, NULL);
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (7, 'KarOls', 'haslohaslo', 3, NULL);
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (8, 'MicDun', 'wow102', 3, NULL);
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (9, 'BłaUła', 'suwalki', 4, NULL);
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (11, 'ArtSol', 'costam', 5, NULL);
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (13, 'MonMak', 'haha', 5, NULL);
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (16, 'MarWoj', 'qazwsxedc', 5, NULL);
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (6, 'PauLis', '123512', 2,'00290112345');
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (10, 'DawDop', 'slask', 2,'70324325324');
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (12, 'HelHaw', 'polskapolska', 4,'53241324341');
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (14, 'MarMat', 'qwerty', 2,'43214123432');
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (15, 'MarPol', 'poqlrk', 2,'95124351324');
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (17, 'TerPaw', 'kocimietka', 2,'12345678901');
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (18, 'JolMyt', 'piesikot', 2,'98765432123');
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (19, 'TomTom', 'porsche', 2,'95124509823');
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (20, 'RenBie', 'polololo', 2,'43231224567');
INSERT INTO public.users (id, username, password, roleid, pesel) VALUES (21, 'AdrZys', 'fajnehaslo', 5, NULL);





--
-- TOC entry 3180 (class 0 OID 0)
-- Dependencies: 215
-- Name: companies_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.companies_id_seq', 4, true);
SELECT pg_catalog.setval('public.appointments_id_seq', 8, true);


--
-- TOC entry 3181 (class 0 OID 0)
-- Dependencies: 211
-- Name: invoices_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.invoices_id_seq', 4, true);

SELECT pg_catalog.setval('public.roles_id_seq', 6, true);


--
-- TOC entry 3182 (class 0 OID 0)
-- Dependencies: 205
-- Name: medical_records_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.medical_records_id_seq', 11, true);


--
-- TOC entry 3183 (class 0 OID 0)
-- Dependencies: 202
-- Name: notifications_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.notifications_id_seq', 7, true);


--
-- TOC entry 3184 (class 0 OID 0)
-- Dependencies: 209
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orders_id_seq', 1, false);


--
-- TOC entry 3185 (class 0 OID 0)
-- Dependencies: 200
-- Name: patients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.patients_id_seq', 11, true);


--
-- TOC entry 3186 (class 0 OID 0)
-- Dependencies: 213
-- Name: payments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.payments_id_seq', 10, true);


--
-- TOC entry 3187 (class 0 OID 0)
-- Dependencies: 207
-- Name: services_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.services_id_seq', 8, true);


--
-- TOC entry 3188 (class 0 OID 0)
-- Dependencies: 217
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 22, true);


--
-- TOC entry 2970 (class 2606 OID 16891)
-- Name: companies companies_nip_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.companies
    ADD CONSTRAINT companies_nip_key UNIQUE (nip);


--
-- TOC entry 2972 (class 2606 OID 16889)
-- Name: companies companies_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.companies
    ADD CONSTRAINT companies_pkey PRIMARY KEY (id);


--
-- TOC entry 2981 (class 2606 OID 16912)
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);


--
-- TOC entry 2966 (class 2606 OID 16870)
-- Name: invoices invoices_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoices
    ADD CONSTRAINT invoices_pkey PRIMARY KEY (id);


--
-- TOC entry 2959 (class 2606 OID 16840)
-- Name: medical_records medical_records_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medical_records
    ADD CONSTRAINT medical_records_pkey PRIMARY KEY (id);


--
-- TOC entry 2955 (class 2606 OID 16821)
-- Name: notifications notifications_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notifications
    ADD CONSTRAINT notifications_pkey PRIMARY KEY (id);


--
-- TOC entry 2964 (class 2606 OID 16859)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- TOC entry 2984 (class 2606 OID 16925)
-- Name: orders_services orders_services_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders_services
    ADD CONSTRAINT orders_services_pkey PRIMARY KEY (ordersid, servicesid);


--
-- TOC entry 2953 (class 2606 OID 16810)
-- Name: patients patients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.patients
    ADD CONSTRAINT patients_pkey PRIMARY KEY (id);


--
-- TOC entry 2968 (class 2606 OID 16878)
-- Name: payments payments_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payments
    ADD CONSTRAINT payments_pkey PRIMARY KEY (id);


--
-- TOC entry 2957 (class 2606 OID 16829)
-- Name: prescriptions prescriptions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prescriptions
    ADD CONSTRAINT prescriptions_pkey PRIMARY KEY (id);


--
-- TOC entry 2961 (class 2606 OID 16851)
-- Name: services services_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.services
    ADD CONSTRAINT services_pkey PRIMARY KEY (id);


--
-- TOC entry 2974 (class 2606 OID 16902)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2976 (class 2606 OID 16904)
-- Name: users users_username_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);
--
-- TOC entry 2977 (class 1259 OID 16929)
-- Name: employees_first_name; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX employees_first_name ON public.employees USING btree (first_name);


--
-- TOC entry 2978 (class 1259 OID 16930)
-- Name: employees_last_name; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX employees_last_name ON public.employees USING btree (last_name);


--
-- TOC entry 2979 (class 1259 OID 16931)
-- Name: employees_license_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX employees_license_id ON public.employees USING btree (license_id);


--
-- TOC entry 2982 (class 1259 OID 16932)
-- Name: employees_specialisation; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX employees_specialisation ON public.employees USING btree (specialisation);


--
-- TOC entry 2950 (class 1259 OID 16926)
-- Name: patients_first_name; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX patients_first_name ON public.patients USING btree (first_name);


--
-- TOC entry 2951 (class 1259 OID 16927)
-- Name: patients_last_name; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX patients_last_name ON public.patients USING btree (last_name);


--
-- TOC entry 2962 (class 1259 OID 16928)
-- Name: services_service_name; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX services_service_name ON public.services USING btree (service_name);


--
-- TOC entry 2997 (class 2606 OID 16983)
-- Name: employees fkemployees389253; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT fkemployees389253 FOREIGN KEY (usersid) REFERENCES public.users(id) ON DELETE CASCADE;

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fkusers13372115 FOREIGN KEY (roleid) REFERENCES public.roles(id) ON DELETE CASCADE;
--
-- TOC entry 2989 (class 2606 OID 16948)
-- Name: medical_records fkmedical_re344218; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medical_records
    ADD CONSTRAINT fkmedical_re344218 FOREIGN KEY (patientsid) REFERENCES public.patients(id) ON DELETE CASCADE;

ALTER TABLE ONLY public.medical_records
    ADD CONSTRAINT fkmedical_re133337 FOREIGN KEY (employeesid) REFERENCES public.employees(id) ON DELETE CASCADE;


--
-- TOC entry 2986 (class 2606 OID 16943)
-- Name: notifications fknotificati923780; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notifications
    ADD CONSTRAINT fknotificati923780 FOREIGN KEY (patientsid) REFERENCES public.patients(id) ON DELETE CASCADE;


--
-- TOC entry 2992 (class 2606 OID 17018)
-- Name: orders fkorders171129; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fkorders171129 FOREIGN KEY (paymentsid) REFERENCES public.payments(id) ON DELETE CASCADE;


--
-- TOC entry 2990 (class 2606 OID 16953)
-- Name: orders fkorders175005; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fkorders175005 FOREIGN KEY (patientsid) REFERENCES public.patients(id) ON DELETE CASCADE;


--
-- TOC entry 2991 (class 2606 OID 17003)
-- Name: orders fkorders896496; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fkorders896496 FOREIGN KEY (employeesid) REFERENCES public.employees(id) ON DELETE CASCADE;


--
-- TOC entry 2999 (class 2606 OID 16938)
-- Name: orders_services fkorders_ser30058; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders_services
    ADD CONSTRAINT fkorders_ser30058 FOREIGN KEY (servicesid) REFERENCES public.services(id) ON DELETE CASCADE;


--
-- TOC entry 2998 (class 2606 OID 16933)
-- Name: orders_services fkorders_ser481258; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders_services
    ADD CONSTRAINT fkorders_ser481258 FOREIGN KEY (ordersid) REFERENCES public.orders(id) ON DELETE CASCADE;


--
-- TOC entry 2985 (class 2606 OID 16978)
-- Name: patients fkpatients915134; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.patients
    ADD CONSTRAINT fkpatients915134 FOREIGN KEY (usersid) REFERENCES public.users(id) ON DELETE CASCADE;


--
-- TOC entry 2994 (class 2606 OID 16993)
-- Name: payments fkpayments157982; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payments
    ADD CONSTRAINT fkpayments157982 FOREIGN KEY (employeesid) REFERENCES public.employees(id) ON DELETE CASCADE;


--
-- TOC entry 2995 (class 2606 OID 16998)
-- Name: payments fkpayments293470; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payments
    ADD CONSTRAINT fkpayments293470 FOREIGN KEY (companiesid) REFERENCES public.companies(id) ON DELETE SET NULL;


--
-- TOC entry 2993 (class 2606 OID 16988)
-- Name: payments fkpayments913519; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payments
    ADD CONSTRAINT fkpayments913519 FOREIGN KEY (patientsid) REFERENCES public.patients(id) ON DELETE CASCADE;


--
-- TOC entry 2996 (class 2606 OID 17013)
-- Name: payments fkpayments982381; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payments
    ADD CONSTRAINT fkpayments982381 FOREIGN KEY (invoicesid) REFERENCES public.invoices(id) ON DELETE SET NULL;


--
-- TOC entry 2988 (class 2606 OID 16968)
-- Name: prescriptions fkprescripti233514; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prescriptions
    ADD CONSTRAINT fkprescripti233514 FOREIGN KEY (employeesid) REFERENCES public.employees(id) ON DELETE CASCADE;


--
-- TOC entry 2987 (class 2606 OID 16963)
-- Name: prescriptions fkprescripti837987; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prescriptions
    ADD CONSTRAINT fkprescripti837987 FOREIGN KEY (patientsid) REFERENCES public.patients(id) ON DELETE CASCADE;


--
-- TOC entry 3160 (class 0 OID 0)
-- Dependencies: 221
-- Name: TABLE appointments; Type: ACL; Schema: public; Owner: postgres
--
GRANT SELECT,INSERT,DELETE, UPDATE ON TABLE public.roles TO administrator;
GRANT SELECT ON public.roles TO clinicworker;
GRANT SELECT ON TABLE public.roles TO doctor;
GRANT SELECT ON TABLE public.roles TO labworker;
GRANT SELECT ON TABLE public.roles TO patient;

GRANT SELECT,USAGE ON SEQUENCE public.roles_id_seq TO labworker;
GRANT SELECT,USAGE ON SEQUENCE public.roles_id_seq TO doctor;
GRANT SELECT,USAGE ON SEQUENCE public.roles_id_seq TO patient;
GRANT SELECT,USAGE ON SEQUENCE public.roles_id_seq TO clinicworker;

GRANT SELECT,USAGE ON SEQUENCE public.appointments_id_seq TO labworker;
GRANT SELECT,USAGE ON SEQUENCE public.appointments_id_seq TO doctor;
GRANT SELECT,USAGE ON SEQUENCE public.appointments_id_seq TO patient;
GRANT SELECT,USAGE ON SEQUENCE public.appointments_id_seq TO clinicworker;

GRANT SELECT,INSERT,DELETE ON TABLE public.appointments TO clinicworker;

GRANT SELECT ON TABLE public.appointments TO doctor;
GRANT SELECT ON TABLE public.appointments TO patient;


--
-- TOC entry 3161 (class 0 OID 0)
-- Dependencies: 219
-- Name: TABLE employees; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT ON TABLE public.employees TO clinicworker;


--
-- TOC entry 3162 (class 0 OID 0)
-- Dependencies: 208
-- Name: TABLE services; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT ON TABLE public.services TO clinicworker;
GRANT SELECT ON TABLE public.services TO doctor;
GRANT SELECT ON TABLE public.services TO patient;


--
-- TOC entry 3163 (class 0 OID 0)
-- Dependencies: 216
-- Name: TABLE companies; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE ON TABLE public.companies TO clinicworker;


--
-- TOC entry 3165 (class 0 OID 0)
-- Dependencies: 212
-- Name: TABLE invoices; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT ON TABLE public.invoices TO clinicworker;


--
-- TOC entry 3167 (class 0 OID 0)
-- Dependencies: 206
-- Name: TABLE medical_records; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT ON TABLE public.medical_records TO clinicworker;
GRANT SELECT,INSERT ON TABLE public.medical_records TO doctor;
GRANT SELECT ON TABLE public.medical_records TO patient;
GRANT INSERT ON TABLE public.medical_records TO labworker;


--
-- TOC entry 3169 (class 0 OID 0)
-- Dependencies: 205
-- Name: SEQUENCE medical_records_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.medical_records_id_seq TO labworker;
GRANT SELECT,USAGE ON SEQUENCE public.medical_records_id_seq TO doctor;
GRANT SELECT,USAGE ON SEQUENCE public.medical_records_id_seq TO patient;
GRANT SELECT,USAGE ON SEQUENCE public.medical_records_id_seq TO clinicworker;

--
-- TOC entry 3171 (class 0 OID 0)
-- Dependencies: 210
-- Name: TABLE orders; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE ON TABLE public.orders TO clinicworker;
GRANT SELECT,INSERT ON TABLE public.orders TO patient;


--
-- TOC entry 3173 (class 0 OID 0)
-- Dependencies: 201
-- Name: TABLE patients; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,UPDATE ON TABLE public.patients TO clinicworker;
GRANT SELECT ON TABLE public.patients TO doctor;


--
-- TOC entry 3175 (class 0 OID 0)
-- Dependencies: 214
-- Name: TABLE payments; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT ON TABLE public.payments TO clinicworker;
GRANT SELECT ON TABLE public.payments TO patient;


--
-- TOC entry 3177 (class 0 OID 0)
-- Dependencies: 204
-- Name: TABLE prescriptions; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT ON TABLE public.prescriptions TO doctor;
GRANT SELECT ON TABLE public.prescriptions TO patient;


-- Completed on 2020-11-23 17:00:45

--
-- PostgreSQL database dump complete
--
GRANT USAGE ON schema public TO clinicworker;
GRANT USAGE ON schema public TO doctor;
GRANT USAGE ON schema public TO labworker;
GRANT USAGE ON schema public TO patient;
GRANT USAGE ON schema public TO administrator;
 
