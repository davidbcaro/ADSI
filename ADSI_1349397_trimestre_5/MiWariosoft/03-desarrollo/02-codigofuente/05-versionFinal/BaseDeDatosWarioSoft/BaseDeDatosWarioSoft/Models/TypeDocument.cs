using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class TypeDocument
    {
        [Key]

        public int IdTypeDocument { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Acrónimo")]
        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Index("TypeDocuement_NameTP_Index", IsUnique = true)]
        public string NameTP { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Descripción")]
        public string Description { get; set; }
        public virtual ICollection<User> User { get; set; }

    }
}