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

import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.model.VeiculoDeCarga;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.services.VeiculoDeCargaService;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.services.utils.ResponseService;
import com.sistemadegestaodeveiculos.sistemadegestaodeveiculos.shared.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/veiculo/carga")
@Api(value = "Sistema de gerenciamento de veiculos de carga")
public class VeiculoDeCargaController {

    private final VeiculoDeCargaService veiculoDeCargaService;
    private final ResponseService responseService;
    
    @PostMapping
    @ApiOperation(value = "Salva um veiculo de carga no sistema.")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<VeiculoDeCarga>> save(@RequestBody @Validated VeiculoDeCarga veiculoDeCarga) {
        return responseService.create(veiculoDeCargaService.save(veiculoDeCarga));
    }

    @PutMapping
    @ApiOperation(value = "Valida se o veiculo com o id esta no banco, caso esteja atualiza ele com as informações.")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<VeiculoDeCarga>> updateById(@RequestBody VeiculoDeCarga veiculoDeCarga) {
        return responseService.ok(veiculoDeCargaService.updateById(veiculoDeCarga));
    }

    @DeleteMapping(value = "/deleteByPlaca/{placa}")
    @ApiOperation(value = "Valida se o veiculo com a placa especifica esta salva no banco, caso esteja deleta ele.")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<String>> deleteByPlaca(@PathVariable String placa) {
        veiculoDeCargaService.deleteByPlaca(placa);
        return responseService.ok("O Veiculo com a placa ".concat(placa).concat(" foi deletado com sucesso."));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    @ApiOperation(value = "Valida se o veiculo com o Id especifico esta salvo no banco, caso esteja deleta ele.")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<String>> deleteById(@PathVariable Long id) {
        veiculoDeCargaService.deleteById(id);
        return responseService.ok("O Veiculo com o id ".concat(id.toString()).concat(" foi deletado com sucesso."));
    }

    @GetMapping(value = "/findByPlaca/{placa}")
    @ApiOperation(value = "Busca um veiculo de passeio pela placa no sistema.")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<VeiculoDeCarga>> findByPlaca(@PathVariable String placa) {
        return responseService.ok(veiculoDeCargaService.findByPlaca(placa));
    }

    @GetMapping(value = "/findById/{id}")
    @ApiOperation(value = "Busca um veiculo de carga no sistema pelo Id.")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<VeiculoDeCarga>> findById(@PathVariable Long id) {
        return responseService.ok(veiculoDeCargaService.findById(id));
    }

    @GetMapping
    @ApiOperation(value = "Exibe a lista de veiculos de carga.")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<List<VeiculoDeCarga>>> findAll() {
        return responseService.ok(veiculoDeCargaService.findAll());
    }
}
