using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class Group
    {

        [Key]
        public int groupID { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Numero de ficha")]
        [StringLength(20, ErrorMessage = "Debe tener mínimo dos caracteres, máximo veinte caracteres.", MinimumLength = 2)]
        [Index("Group_numberGroup_Index", IsUnique = true)]
        public String numberGroup { get; set; }

        [DataType(DataType.Date)]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:MM/dd/yyyy}")]
        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Fecha de inicio")]
        public DateTime startDate { get; set; }

        [DataType(DataType.Date)]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:MM/dd/yyyy}")]
        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Fecha final")]
        public DateTime endDate { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Ruta")]
        [StringLength(20, ErrorMessage = "Debe tener mínimo dos caracteres, máximo veinte caracteres.", MinimumLength = 2)]
        [Index("Group_route_Index", IsUnique = true)]
        public String route { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Ruta")]
        public String toUpper
        {
            get
            {
                if (route != null)
                {
                    route = route.ToUpper();
                }
                else
                {
                    route = "Es requerido.";
                }
                return route;
            }
            set
            {
                if (route != null)
                {
                    route = route.ToUpper();
                }
                else
                {
                    route = "Es requerido.";
                }
                route.ToUpper();
            }
        }

        public int stateGroupID { get; set; }
        public virtual StateGroup stateGroup { get; set; }

        public virtual ICollection<Schedule> shedule { get; set; }
        public virtual ICollection<Trimester> trimesters { get; set; }

    }
}