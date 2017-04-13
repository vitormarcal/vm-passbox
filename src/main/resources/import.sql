insert into local_credenciado (id_local_credenciado, local) values (1, 'Facebook');
insert into local_credenciado (id_local_credenciado, local) values (2, 'Gmail');
insert into local_credenciado (id_local_credenciado, local) values (3, 'Hotmail');
insert into local_credenciado (id_local_credenciado, local) values (4, 'Escambal');

insert into pessoa (id_pessoa, nome, genero) values (1, 'Vítor', 'MASCULINO');
insert into pessoa (id_pessoa, nome, genero) values (2, 'Maria', 'FEMININO');
insert into pessoa (id_pessoa, nome, genero) values (3, 'Ricardo', 'MASCULINO');

insert into usuario (id_usuario, user_name) values (1, 'vitormarcal');
insert into usuario (id_usuario, user_name) values (2, 'vimarcal');
insert into usuario (id_usuario, user_name) values (3, 'maria');
insert into usuario (id_usuario, user_name) values (4, 'rigard');

insert into pessoa_usuarios (pessoa_id_pessoa, usuarios_id_usuario) values (1,1); 
insert into pessoa_usuarios (pessoa_id_pessoa, usuarios_id_usuario) values (1,2);
insert into pessoa_usuarios (pessoa_id_pessoa, usuarios_id_usuario) values (2,3);
insert into pessoa_usuarios (pessoa_id_pessoa, usuarios_id_usuario) values (3,4);

insert into senha (id_senha, id_local_credenciado, palavra_passe) values (1, 1, 'estaumasenha');
insert into senha (id_senha, id_local_credenciado, palavra_passe) values (2, 2, 'senha');
insert into senha (id_senha, id_local_credenciado, palavra_passe) values (3, 4, 'password');
insert into senha (id_senha, id_local_credenciado, palavra_passe) values (4, 3, '123456');
insert into senha (id_senha, id_local_credenciado, palavra_passe) values (5, 4, '654789');


insert into usuario_senhas (usuario_id_usuario, senhas_id_senha) values (1,1);
insert into usuario_senhas (usuario_id_usuario, senhas_id_senha) values (1,2);
insert into usuario_senhas (usuario_id_usuario, senhas_id_senha) values (1,3);
insert into usuario_senhas (usuario_id_usuario, senhas_id_senha) values (2,4);
insert into usuario_senhas (usuario_id_usuario, senhas_id_senha) values (3,5);
