package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DTO.DTOCLASS.IngressoDto;
import com.example.demo.DTO.DTOINDIC.IngressoCountDTO;
import com.example.demo.DTO.DTOINDIC.ValorCountDTO;
import com.example.demo.DTO.DTOMapper.IngressoMapper;
import com.example.demo.models.Ingresso;
import com.example.demo.models.IngressoStatus;
import com.example.demo.models.User;
import com.example.demo.repositories.IngressoRepository;

@Service
public class IngressoService {

    //@Autowired
    private IngressoRepository ingressoRepository;

    public IngressoService(IngressoRepository ingressoRepository){
        this.ingressoRepository = ingressoRepository;
    }

    @Autowired
    private UserService userService;

    public Ingresso buscarIngressoPeloId(Long id) {
        Optional<Ingresso> obj = this.ingressoRepository.findById(id);
        
        

        return obj.orElseThrow(() -> new RuntimeException(
            "Não foi possível encontrar o usuário: " + id + " do Tipo= " + User.class.getName()
        )); 
         
    }

    public List<Ingresso> buscarIngressoPeloUserId(Long id){
        List<Ingresso> ingresso = this.ingressoRepository.findPeloUserID(id);

        return ingresso;
    }

    @Transactional
    public Ingresso create(IngressoDto ingressoDto) {
        Ingresso obj = IngressoMapper.toEntity(ingressoDto);

        User user = this.userService.buscarPeloIdUser(ingressoDto.getIdUser());

        obj.setCompra(null);
        obj.setId(null);
        obj.setUser(user);
        obj.setStatus(IngressoStatus.NAO_VALIDO);  

        this.ingressoRepository.save(obj);

        return obj;
    }

    @Transactional
    public Ingresso update(Ingresso ingresso) {
        Ingresso obj = this.buscarIngressoPeloId(ingresso.getId());
    
        obj.setDescription(ingresso.getDescription());
        obj.setData(ingresso.getData());
        obj.setStatus(ingresso.getStatus());
        // Adicionar aqui obj.setATRIBUTO() caso inclua novos atributos
    
        return this.ingressoRepository.save(obj);
    }

    public void delete(Long id) {
        Ingresso ingresso = this.buscarIngressoPeloId(id);

        try {
            this.ingressoRepository.delete(ingresso);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível deletar o ingresso: " + ingresso.getDescription());
        }
    }
 
    public IngressoCountDTO countTotalIngressos() {
        return ingressoRepository.countTotalIngressos();
    }

    public ValorCountDTO sumTotalValorIngressos() {
        return ingressoRepository.sumTotalValorIngressos();
    }

}

