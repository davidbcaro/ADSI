using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class Headquarters
    {
        [Key]
        public int IdHeadquarters { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Sede")]
        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Index("Linkage_TypeLinkage_Index", IsUnique = true)]
        public string NameHeadquarters { get; set; }


        [DataType(DataType.MultilineText)]
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Descripción")]
        public string Description { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Estado")]
        public bool State { get; set; }

        public virtual ICollection<Shedule> Shedule { get; set; }
    }
}