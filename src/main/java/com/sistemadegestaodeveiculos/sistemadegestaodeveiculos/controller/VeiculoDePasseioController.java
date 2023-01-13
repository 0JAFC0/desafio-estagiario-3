package com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.model.VeiculoDePasseio;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.services.VeiculoDePasseioService;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.services.utils.ResponseService;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.shared.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/veiculo/passeio")
@Api(value = "Sistema de gerenciamento de veiculos de passeio")
public class VeiculoDePasseioController {
    
    private final VeiculoDePasseioService veiculoDePasseioService;
    private final ResponseService responseService;
    
    @PostMapping
    @ApiOperation(value = "Salva um veiculo de passeio no sistema.")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<VeiculoDePasseio>> save(@RequestBody @Validated VeiculoDePasseio veiculoDePasseio) {
        return responseService.create(veiculoDePasseioService.save(veiculoDePasseio));
    }

    @PutMapping
    @ApiOperation(value = "Valida se o veiculo com o id esta no banco, caso esteja atualiza ele com as informações.")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<VeiculoDePasseio>> updateById(@RequestBody VeiculoDePasseio veiculoDePasseio) {
        return responseService.ok(veiculoDePasseioService.updateById(veiculoDePasseio));
    }

    @DeleteMapping(value = "/deleteByPlaca/{placa}")
    @ApiOperation(value = "Valida se o veiculo com a placa especifica esta salva no banco, caso esteja deleta ele.")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<String>> deleteByPlaca(@PathVariable String placa) {
        veiculoDePasseioService.deleteByPlaca(placa);
        return responseService.ok("O Veiculo com a placa ".concat(placa).concat(" foi deletado com sucesso."));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    @ApiOperation(value = "Valida se o veiculo com o Id especifico esta salvo no banco, caso esteja deleta ele.")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<String>> deleteById(@PathVariable Long id) {
        veiculoDePasseioService.deleteById(id);
        return responseService.ok("O Veiculo com o id ".concat(id.toString()).concat(" foi deletado com sucesso."));
    }

    @GetMapping(value = "/findByPlaca/{placa}")
    @ApiOperation(value = "Busca um veiculo de passeio pela placa no sistema.")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<VeiculoDePasseio>> findByPlaca(@PathVariable String placa) {
        return responseService.ok(veiculoDePasseioService.findByPlaca(placa));
    }

    @GetMapping(value = "/findById/{id}")
    @ApiOperation(value = "Busca um veiculo de passeio pelo Id no sistema.")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<VeiculoDePasseio>> findById(@PathVariable Long id) {
        return responseService.ok(veiculoDePasseioService.findById(id));
    }

    @GetMapping
    @ApiOperation(value = "Busca todos os veiculos de passeio no sistema.")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<List<VeiculoDePasseio>>> findAll() {
        return responseService.ok(veiculoDePasseioService.findAll());
    }

}
