CREATE TABLE tool_tags (
    tool_id BIGSERIAL NOT NULL,
    tag TEXT NOT NULL,
    FOREIGN KEY (tool_id) REFERENCES tools (id) ON DELETE CASCADE
);