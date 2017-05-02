insert into local_credenciado (id_local_credenciado, local) values (1, 'Facebook');
insert into local_credenciado (id_local_credenciado, local) values (2, 'Gmail');
insert into local_credenciado (id_local_credenciado, local) values (3, 'Hotmail');
insert into local_credenciado (id_local_credenciado, local) values (4, 'Escambal');

insert into pessoa (id_pessoa, nome, genero) values (1, 'Vítor', 'MASCULINO');
insert into pessoa (id_pessoa, nome, genero) values (2, 'Maria', 'FEMININO');
insert into pessoa (id_pessoa, nome, genero) values (3, 'Ricardo', 'MASCULINO');

insert into usuario (id_usuario, user_name, id_pessoa) values (1, 'vitormarcal', 1);
insert into usuario (id_usuario, user_name, id_pessoa) values (2, 'vimarcal', 1);
insert into usuario (id_usuario, user_name, id_pessoa) values (3, 'maria', 2);
insert into usuario (id_usuario, user_name, id_pessoa) values (4, 'rigard', 3);

insert into senha (id_senha, id_local_credenciado, palavra_passe, usuario_id) values (1, 1, 'estaumasenha', 1);
insert into senha (id_senha, id_local_credenciado, palavra_passe, usuario_id) values (2, 2, 'senha', 1);
insert into senha (id_senha, id_local_credenciado, palavra_passe, usuario_id) values (3, 4, 'password', 2);
insert into senha (id_senha, id_local_credenciado, palavra_passe, usuario_id) values (4, 3, '123456', 3);
insert into senha (id_senha, id_local_credenciado, palavra_passe, usuario_id) values (5, 4, '654789', 4);


