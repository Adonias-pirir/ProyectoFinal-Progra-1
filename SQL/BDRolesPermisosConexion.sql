--
-- PostgreSQL database dump
--
-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4
-- Started on 2025-05-07 19:26:46
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;
SET default_tablespace = '';
SET default_table_access_method = heap;
--
-- TOC entry 218 (class 1259 OID 16390)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--
CREATE TABLE public.roles (
--     id integer NOT NULL,
--     nombrerol character varying(50),
--     descriprol character varying(50),
--     nombrepermiso character varying(50),
--     descrippermiso character varying(50);
-- );
--
-- TOC entry 217 (class 1259 OID 16389)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--
CREATE SEQUENCE public.roles_id_seq
AS integer
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;
ALTER SEQUENCE public.roles_id_seq OWNER TO postgres;
--
-- TOC entry 4824 (class 0 OID 0)
-- Dependencies: 217
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--
ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;
--
-- TOC entry 222 (class 1259 OID 16410)
-- Name: tickets; Type: TABLE; Schema: public; Owner: postgres
--
CREATE TABLE public.tickets (
--     id integer NOT NULL,
--     nombre_estado character varying(100) NOT NULL,
--     descripcion_estado text NOT NULL,
--     fecha_creacion character varying(50) DEFAULT CURRENT_TIMESTAMP,
--     usuario_id integer,
--     estado_final character varying(20) NOT NULL,
--     estados_permitidos character varying(255),
--     CONSTRAINT tickets_estado_check CHECK (((estado_final)::text = ANY ((ARRAY['pendiente'::character varying, 'en proceso'::character varying, 'escalado'::character varying, 'resuelto'::character varying, 'cerrado'::character varying])::text[])));
-- );
--
-- TOC entry 221 (class 1259 OID 16409)
-- Name: tickets_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--
CREATE SEQUENCE public.tickets_id_seq
--     AS integer
--     START WITH 1
--     INCREMENT BY 1
--     NO MINVALUE
--     NO MAXVALUE
--     CACHE 1;
ALTER SEQUENCE public.tickets_id_seq OWNER TO postgres;
--
-- TOC entry 4825 (class 0 OID 0)
-- Dependencies: 221
-- Name: tickets_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--
ALTER SEQUENCE public.tickets_id_seq OWNED BY public.tickets.id;
--
-- TOC entry 220 (class 1259 OID 16397)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--
CREATE TABLE public.usuarios (
--     id integer NOT NULL,
--     nombres character varying(50) NOT NULL,
--     apellidos character varying(100) NOT NULL,
--     email character varying(100) NOT NULL,
--     nombre_usuario character varying(50) NOT NULL,
--     "contraseña" character varying(255) NOT NULL,
--     rol_asignado character varying(50) NOT NULL,
--     departamento character varying(100),
-- );
--
-- TOC entry 219 (class 1259 OID 16396)
-- Name: usuarios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--
CREATE SEQUENCE public.usuarios_id_seq
--     AS integer
--     START WITH 1
--     INCREMENT BY 1
--     NO MINVALUE
--     NO MAXVALUE
--     CACHE 1;
ALTER SEQUENCE public.usuarios_id_seq OWNER TO postgres;
--
-- TOC entry 4826 (class 0 OID 0)
-- Dependencies: 219
-- Name: usuarios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--
ALTER SEQUENCE public.usuarios_id_seq OWNED BY public.usuarios.id;
--
-- TOC entry 4651 (class 2604 OID 16393)
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--
ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);
--
-- TOC entry 4653 (class 2604 OID 16413)
-- Name: tickets id; Type: DEFAULT; Schema: public; Owner: postgres
--
ALTER TABLE ONLY public.tickets ALTER COLUMN id SET DEFAULT nextval('public.tickets_id_seq'::regclass);
--
-- TOC entry 4652 (class 2604 OID 16428)
-- Name: usuarios id; Type: DEFAULT; Schema: public; Owner: postgres
--
ALTER TABLE ONLY public.usuarios ALTER COLUMN id SET DEFAULT nextval('public.usuarios_id_seq'::regclass);
--
-- TOC entry 4814 (class 0 OID 16390)
-- Dependencies: 218
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--
COPY public.roles (id, nombrerol, descriprol, nombrepermiso, descrippermiso) FROM stdin;
-- 2	Administrado	acceso	Registrar	Modificar, eliminar
--
-- TOC entry 4818 (class 0 OID 16410)
-- Dependencies: 222
-- Data for Name: tickets; Type: TABLE DATA; Schema: public; Owner: postgres
--
COPY public.tickets (id, nombre_estado, descripcion_estado, fecha_creacion, usuario_id, estado_final, estados_permitidos) FROM stdin;
-- 1	Nuevo	Aun no ha sido asignado	2025-04-24	3	resuelto	Pendiente
-- 7	Abierto	Trabajando para resolverlo	2025-04-24	2	cerrado	En proceso
-- 8	Abierto	Trabajando para resolverlo	2025-04-24	2	resuelto	En proceso
--
-- TOC entry 4816 (class 0 OID 16397)
-- Dependencies: 220
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--
COPY public.usuarios (id, nombres, apellidos, email, nombre_usuario, "contraseña", rol_asignado, departamento) FROM stdin;
-- 3	beberly mayerly	esqueque	beberly99@gmail.com	mayerly	9808632	usuario	
-- 4	josue adonias	pirir pirir	adonai111@gmail.com	adonai pirir	435572	administrador	
-- 5	ester abigail	xiquin pirir	abi2425@hotmail.com	abigail xiquin	59867011	usuario	
-- 2	Usuario	Prueba	usuario2@example.com	usuario2	123456	usuario	soporte
-- 1	Carlos	Pirir	estuardo@gmail.com	carlospirir	87965	usuario	\N
--
-- TOC entry 4827 (class 0 OID 0)
-- Dependencies: 217
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--
SELECT pg_catalog.setval('public.roles_id_seq', 2, true);
--
-- TOC entry 4828 (class 0 OID 0)
-- Dependencies: 221
-- Name: tickets_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--
SELECT pg_catalog.setval('public.tickets_id_seq', 9, true);
--
-- TOC entry 4829 (class 0 OID 0)
-- Dependencies: 219
-- Name: usuarios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--
SELECT pg_catalog.setval('public.usuarios_id_seq', 5, true);
--
-- TOC entry 4657 (class 2606 OID 16395)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--
ALTER TABLE ONLY public.roles
--     ADD CONSTRAINT roles_pkey PRIMARY KEY (id);
--
-- TOC entry 4665 (class 2606 OID 16419)
-- Name: tickets tickets_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--
ALTER TABLE ONLY public.tickets
--     ADD CONSTRAINT tickets_pkey PRIMARY KEY (id);
--
-- TOC entry 4659 (class 2606 OID 16406)
-- Name: usuarios usuarios_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--
ALTER TABLE ONLY public.usuarios
--     ADD CONSTRAINT usuarios_email_key UNIQUE (email);
--
-- TOC entry 4661 (class 2606 OID 16408)
-- Name: usuarios usuarios_nombre_usuario_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--
ALTER TABLE ONLY public.usuarios
--     ADD CONSTRAINT usuarios_nombre_usuario_key UNIQUE (nombre_usuario);
--
-- TOC entry 4663 (class 2606 OID 16404)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--
ALTER TABLE ONLY public.usuarios
--     ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);
--
-- TOC entry 4666 (class 2606 OID 16436)
-- Name: tickets fk_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--
ALTER TABLE ONLY public.tickets
--     ADD CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES public.usuarios(id);
--
-- TOC entry 4667 (class 2606 OID 16420)
-- Name: tickets tickets_usuario_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--
ALTER TABLE ONLY public.tickets
--     ADD CONSTRAINT tickets_usuario_id_fkey FOREIGN KEY (usuario_id) REFERENCES public.usuarios(id);
-- Completed on 2025-05-07 19:26:46
--
-- PostgreSQL database dump complete
--
