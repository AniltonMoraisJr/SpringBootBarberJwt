/*
    USER = admin
    PASSWORD = 123456
*/

INSERT INTO users (id, "name", username, email, password, created_at, updated_at)
VALUES ('10e3da49-b6e9-4cab-9759-72161bda16f4'::uuid, 'Administrador do Sistema', 'admin', 'admin@admin.com', '$2a$10$r0RFDmpneBVryx.ihHK9gu6FFJQi4nTxQUqzdSTvrPpaKZMxigqpy', now(), now());

INSERT INTO user_roles (user_id, role_id) VALUES ('10e3da49-b6e9-4cab-9759-72161bda16f4'::uuid, 'd8df23b7-9c89-4bd6-8479-662b666a57b3'::uuid);