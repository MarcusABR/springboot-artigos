package br.com.bb.letscode.artigos.controller;

public class ComentarioController {
    
    @Autowired
    final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario){
        log.info(usuario.toString());
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping(value = {
        "/",
        "/{id}"
    })
    public ResponseEntity<List<Usuario>> getAll(@PathVariable(value = "id", required = false) Long id){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }
}
