--SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname = "MedClinic";
--DROP DATABASE IF EXISTS "MedClinic";

--SET statement_timeout = 0;
--SET lock_timeout = 0;
--SET idle_in_transaction_session_timeout = 0;
--SET client_encoding = 'UTF8';
--SET standard_conforming_strings = on;
--SELECT pg_catalog.set_config('search_path', '', false);
--SET check_function_bodies = false;
--SET xmloption = content;
--SET client_min_messages = warning;
--SET row_security = off;


--REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA public FROM clinicworker;
--REVOKE ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public FROM clinicworker;
--REVOKE ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA public FROM clinicworker;
--REVOKE USAGE ON SCHEMA public FROM clinicworker;
--DROP USER IF EXISTS clinicworker;

--REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA public FROM doctor;
--REVOKE ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public FROM doctor;
--REVOKE ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA public FROM doctor;
--REVOKE USAGE ON SCHEMA public FROM doctor;
--DROP USER IF EXISTS doctor;

--REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA public FROM labworker;
--REVOKE ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public FROM labworker;
--REVOKE ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA public FROM labworker;
--REVOKE USAGE ON SCHEMA public FROM labworker;
--DROP USER IF EXISTS labworker;

--REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA public FROM patient;
--REVOKE ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public FROM patient;
--REVOKE ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA public FROM patient;
--REVOKE USAGE ON SCHEMA public FROM patient;
--DROP USER IF EXISTS patient;

--REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA public FROM administrator;
--REVOKE ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public FROM administrator;
--REVOKE ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA public FROM administrator;
--REVOKE USAGE ON SCHEMA public FROM administrator;
--DROP USER IF EXISTS administrator;

CREATE ROLE doctor
LOGIN
PASSWORD '123';

CREATE ROLE clinicworker
LOGIN
PASSWORD '123';

CREATE ROLE labworker
LOGIN
PASSWORD '123';

CREATE ROLE patient
LOGIN
PASSWORD '123';

CREATE ROLE administrator WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  REPLICATION
  ENCRYPTED PASSWORD 'md5bcffcd0fb99fa9e7a0a5eb7f73bd4c5e';

--CREATE DATABASE "MedClinic" WITH TEMPLATE = template0 ENCODING = 'UTF8';

ALTER DATABASE "MedClinic" OWNER TO postgres;

\connect "MedClinic"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

CREATE TABLE public.appointments (
    id integer NOT NULL,
    room_number character varying(10) NOT NULL,
    date date NOT NULL,
    patientsid integer NOT NULL,
    employeesid character varying(50) NOT NULL,
    CONSTRAINT appointments_date CHECK ((date >= '1990-01-01'::date))
);


ALTER TABLE public.appointments OWNER TO postgres;

CREATE SEQUENCE public.appointments_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.appointments_id_seq OWNER TO postgres;

ALTER SEQUENCE public.appointments_id_seq OWNED BY public.appointments.id;

CREATE TABLE public.employees (
    id character varying(50) NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(50) NOT NULL,
    license_id character varying(100),
    is_active boolean NOT NULL,
    hire_date date NOT NULL,
    salary real,
    address character varying(100),
    city character varying(50),
    postcode character varying(10),
    phone_number character varying(20) NOT NULL,
    email_address character varying(150),
    usersid integer NOT NULL,
    specialisation character varying(100),
    CONSTRAINT emloyees_hire_date CHECK ((hire_date >= '1990-01-01'::date))
);


ALTER TABLE public.employees OWNER TO postgres;

CREATE VIEW public.available_doctors_and_specialist AS
 SELECT employees.first_name,
    employees.last_name,
    employees.specialisation
   FROM public.employees
  WHERE ((employees.is_active = true) AND ((employees.id)::text ~~ 'D%'::text));


ALTER TABLE public.available_doctors_and_specialist OWNER TO postgres;

CREATE TABLE public.services (
    id integer NOT NULL,
    service_name character varying(200) NOT NULL,
    price real,
    service_description character varying(5000)
);


ALTER TABLE public.services OWNER TO postgres;

CREATE VIEW public.available_services AS
 SELECT services.service_name,
    services.price,
    services.service_description
   FROM public.services
  WHERE (services.price IS NOT NULL);


ALTER TABLE public.available_services OWNER TO postgres;

CREATE TABLE public.companies (
    id integer NOT NULL,
    company_name character varying(500) NOT NULL,
    nip bigint NOT NULL,
    address character varying(150),
    city character varying(150),
    postcode character varying(10)
);


ALTER TABLE public.companies OWNER TO postgres;

CREATE SEQUENCE public.companies_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.companies_id_seq OWNER TO postgres;

ALTER SEQUENCE public.companies_id_seq OWNED BY public.companies.id;

CREATE TABLE public.invoices (
    id integer NOT NULL,
    invoice bytea NOT NULL
);


ALTER TABLE public.invoices OWNER TO postgres;


CREATE SEQUENCE public.invoices_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.invoices_id_seq OWNER TO postgres;


ALTER SEQUENCE public.invoices_id_seq OWNED BY public.invoices.id;


CREATE TABLE public.medical_records (
    id integer NOT NULL,
    description character varying(3000) NOT NULL,
    date date NOT NULL,
    attachment bytea,
    patientsid integer NOT NULL,
    employeesid character varying(50) NOT NULL,
    CONSTRAINT medical_records_date CHECK ((date >= '1990-01-01'::date))
);


ALTER TABLE public.medical_records OWNER TO postgres;

CREATE SEQUENCE public.medical_records_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.medical_records_id_seq OWNER TO postgres;

ALTER SEQUENCE public.medical_records_id_seq OWNED BY public.medical_records.id;

CREATE TABLE public.notifications (
    id integer NOT NULL,
    description character varying(500) NOT NULL,
    date date NOT NULL,
    patientsid integer NOT NULL,
    CONSTRAINT notifications_date CHECK ((date >= '1990-01-01'::date))
);


ALTER TABLE public.notifications OWNER TO postgres;

CREATE SEQUENCE public.notifications_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.notifications_id_seq OWNER TO postgres;

ALTER SEQUENCE public.notifications_id_seq OWNED BY public.notifications.id;

CREATE TABLE public.orders (
    id integer NOT NULL,
    patientsid integer NOT NULL,
    paymentsid integer NOT NULL,
    employeesid character varying(50) NOT NULL
);


ALTER TABLE public.orders OWNER TO postgres;

CREATE SEQUENCE public.orders_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orders_id_seq OWNER TO postgres;

ALTER SEQUENCE public.orders_id_seq OWNED BY public.orders.id;

CREATE TABLE public.orders_services (
    ordersid integer NOT NULL,
    servicesid integer NOT NULL
);


ALTER TABLE public.orders_services OWNER TO postgres;

CREATE TABLE public.patients (
    id integer NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(50) NOT NULL,
    birth_date date NOT NULL,
    blood_type character varying(10),
    address character varying(100) NOT NULL,
    city character varying(50) NOT NULL,
    postcode character varying(10) NOT NULL,
    permanent_address character varying(100),
    pemanent_city character varying(50),
    permanent_postcode character varying(10),
    phone_number character varying(20) NOT NULL,
    contact_phone character varying(20),
    email_address character varying(150),
    usersid integer NOT NULL,
    notifications_status boolean,
    CONSTRAINT patients_blood_type CHECK (((blood_type)::text = ANY ((ARRAY['A+'::character varying, 'A-'::character varying, 'B+'::character varying, 'B-'::character varying, '0+'::character varying, '0-'::character varying, 'AB+'::character varying, 'AB-'::character varying, NULL])::text[])))
);


ALTER TABLE public.patients OWNER TO postgres;

CREATE SEQUENCE public.patients_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.patients_id_seq OWNER TO postgres;

ALTER SEQUENCE public.patients_id_seq OWNED BY public.patients.id;

CREATE TABLE public.payments (
    id integer NOT NULL,
    date date,
    payment_method character varying(100),
    payment_status character varying(50),
    total_price real NOT NULL,
    patientsid integer NOT NULL,
    companiesid integer,
    employeesid character varying(50) NOT NULL,
    invoicesid integer,
    CONSTRAINT payments_date CHECK ((date >= '1990-01-01'::date)),
    CONSTRAINT payments_payment_method CHECK (((payment_method)::text = ANY ((ARRAY['Cash'::character varying, 'Debit card'::character varying, 'Credit card'::character varying, 'Mobile payment'::character varying, 'Electronic bank transfer'::character varying])::text[]))),
    CONSTRAINT payments_payment_status CHECK (((payment_status)::text = ANY ((ARRAY['Pending'::character varying, 'Success'::character varying, 'Complete'::character varying, 'Canceled'::character varying, 'Rejected'::character varying])::text[])))
);


ALTER TABLE public.payments OWNER TO postgres;


CREATE SEQUENCE public.payments_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.payments_id_seq OWNER TO postgres;

ALTER SEQUENCE public.payments_id_seq OWNED BY public.payments.id;

CREATE TABLE public.prescriptions (
    id character varying(100) NOT NULL,
    date date NOT NULL,
    description character varying(2000) NOT NULL,
    patientsid integer NOT NULL,
    employeesid character varying(50) NOT NULL,
    CONSTRAINT prescriptions_date CHECK ((date >= '1990-01-01'::date))
);

ALTER TABLE public.prescriptions OWNER TO postgres;

CREATE SEQUENCE public.services_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.services_id_seq OWNER TO postgres;

ALTER SEQUENCE public.services_id_seq OWNED BY public.services.id;

CREATE TABLE public.users (
    id integer NOT NULL,    
    username character varying(257) NOT NULL,
    password character varying(257) NOT NULL,
    roleid integer NOT NULL,
    pesel character varying(15)
);


ALTER TABLE public.users OWNER TO postgres;

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.users_id_seq OWNER TO postgres;

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;

ALTER TABLE public.prescriptions OWNER TO postgres;

CREATE TABLE public.roles (
      id integer NOT NULL,
      role character varying(50) NOT NULL
          CONSTRAINT roles_role CHECK (((role)::text = ANY ((ARRAY['ROLE_ADMIN'::character varying, 'ROLE_CLINICWORKER'::character varying, 'ROLE_LABWORKER'::character varying, 'ROLE_PATIENT'::character varying, 'ROLE_DOCTOR'::character varying])::text[])))
);

ALTER TABLE public.roles OWNER TO postgres;

CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO postgres;

ALTER SEQUENCE public.roles_id_seq OWNED BY public.services.id;

ALTER TABLE ONLY public.companies ALTER COLUMN id SET DEFAULT nextval('public.companies_id_seq'::regclass);

ALTER TABLE ONLY public.invoices ALTER COLUMN id SET DEFAULT nextval('public.invoices_id_seq'::regclass);

ALTER TABLE ONLY public.medical_records ALTER COLUMN id SET DEFAULT nextval('public.medical_records_id_seq'::regclass);

ALTER TABLE ONLY public.notifications ALTER COLUMN id SET DEFAULT nextval('public.notifications_id_seq'::regclass);

ALTER TABLE ONLY public.orders ALTER COLUMN id SET DEFAULT nextval('public.orders_id_seq'::regclass);

ALTER TABLE ONLY public.patients ALTER COLUMN id SET DEFAULT nextval('public.patients_id_seq'::regclass);

ALTER TABLE ONLY public.payments ALTER COLUMN id SET DEFAULT nextval('public.payments_id_seq'::regclass);

ALTER TABLE ONLY public.services ALTER COLUMN id SET DEFAULT nextval('public.services_id_seq'::regclass);

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);

ALTER TABLE ONLY public.appointments ALTER COLUMN id SET DEFAULT nextval('public.appointments_id_seq'::regclass);

ALTER SYSTEM SET listen_addresses = '*';

